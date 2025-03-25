package com.example.springpractice.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ButtonPressEventListener {
	
	private int pressCount;
	
	@EventListener
	public void onButtonPressEvent(ButtonPressEvent event) {
		this.pressCount++;
		System.out.println("ボタンが"+ pressCount + "回押されました！");
		
	}

}
