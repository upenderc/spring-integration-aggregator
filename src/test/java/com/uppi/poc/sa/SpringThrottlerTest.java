package com.uppi.poc.sa;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-aggr.xml")
public class SpringThrottlerTest {

	@Autowired
	private ExecutorChannel inputChannel;

	@Test
	public void showMe() throws Exception {
		ThreadPoolExecutor be = new ThreadPoolExecutor(100, 200, 1000, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		List<String> accountIds=Arrays.asList("2701090","4823831","4823832","2701090","4823832","4823832","2701091","4823831");
		for (int i = 0; i <8; i++) {
			be.submit(new TaskSubmiter(inputChannel, accountIds.get(i)));
		}
		TimeUnit.SECONDS.sleep(6);
	}

	private static class TaskSubmiter implements Runnable {
		private final ExecutorChannel inputChannel;
		private final String i;

		public TaskSubmiter(final ExecutorChannel testChannel, final String i) {
			this.inputChannel = testChannel;
			this.i = i;
		}

		@Override
		public void run() {
			EventA a =new EventA();
			a.setEventName("A");
			a.setFpAccountId(Long.parseLong(i));
			inputChannel.send(
					MessageBuilder.withPayload(a).build());
		}

	}
}
