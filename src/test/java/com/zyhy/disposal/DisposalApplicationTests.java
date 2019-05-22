package com.zyhy.disposal;

import com.zyhy.disposal.utils.SSHManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DisposalApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSendCommand()
	{
		System.out.println("sendCommand");

		/**
		 * YOU MUST CHANGE THE FOLLOWING
		 * FILE_NAME: A FILE IN THE DIRECTORY
		 * USER: LOGIN USER NAME
		 * PASSWORD: PASSWORD FOR THAT USER
		 * HOST: IP ADDRESS OF THE SSH SERVER
		 **/
		String command = "ls FILE_NAME";
		String userName = "USER";
		String password = "PASSWORD";
		String connectionIP = "HOST";
		SSHManager instance = new SSHManager(userName, password, connectionIP, "");
		String errorMessage = instance.connect();

		if(errorMessage != null)
		{
			System.out.println(errorMessage);
			fail();
		}

		String expResult = "FILE_NAME\n";
		// call sendCommand for each command and the output
		//(without prompts) is returned
		String result = instance.sendCommand(command);
		// close only after all commands are sent
		System.out.println(result);
		instance.close();
		assertEquals(expResult, result);
	}

}
