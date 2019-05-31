package com.zjs.bwcx.ScriptEngineManager;

public enum Days {
	Sat(0),Sun(1),Mon(2),Tue(3),Wed(4),Thu(5),Fri(6);
	
	private int val;

	private Days(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}
}
