package com.zjs.bwcx.ScriptEngineManager;

public enum Testaa {
	VIDEO(1),AUDIO(2),TEXT(3),IMAGE(4);
	
	private int value;
	
	Testaa(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
}
