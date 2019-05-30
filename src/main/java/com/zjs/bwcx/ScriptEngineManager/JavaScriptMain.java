package com.zjs.bwcx.ScriptEngineManager;

import java.io.StringReader;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.jupiter.api.Test;

public class JavaScriptMain {

	private static int i;
	private static char c;

	public static void main(String[] args) throws ScriptException {
		System.out.println(JavaScriptMain.i);
		System.out.println(JavaScriptMain.c);
		String str = "(a or b) and c";
		str = str.replaceAll("or", "||");
		str = str.replaceAll("and", "&&");
		System.out.println(str);
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.put("a", true);
		engine.put("b", false);
		engine.put("c", true);
		Object eval = engine.eval(str);
		System.out.println("结果类型：" + eval.getClass().getName() + ",计算结果：" + eval);
	}

	@Test
	public void scriptTest() throws ScriptException {
		String option = "(function (a,b,c) {"+
				"try{\r\n"+
					"var hlwbl = a - 0;"+
					"var sjbl = b - 0;"+
					"var ccrcczcs = c - 0;"+
					"var bl  = 0;"+
					"if(ccrcczcs!=0){"+
					"	bl  = (1 - (hlwbl + sjbl))*100;"+
					"}"+
					"if(bl>0  && bl<40){"+
					"	return \"1\";"+
					"}else if(bl>=40 && bl<80){"+
					"	return \"2\";"+
					"}else if(bl>=80 && bl<=100){"+
					"	return \"3\";"+
					"}else if(bl==0){"+
					"	return \"0\";"+
					"}"+
				"}catch(e){"+
				"	return \"-1\";"+
				"}"+
			"})(a,b,c)";
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.put("a", 0.1);
		engine.put("b", 0.2);
		engine.put("c", 0.3);
		Object eval = engine.eval(option);
		System.out.println(eval);
		System.out.println("结果类型：" + eval.getClass().getName() + ",计算结果：" + eval);
	}
	
	@Test
	public void scriptTest8() throws ScriptException {
		String option = "(function (a,b,c) {"+
				"try{\r\n"+
					"var hlwbl = a - 0;"+
					"var sjbl = b - 0;"+
					"var ccrcczcs = c - 0;"+
					"var bl  = 0;"+
					"if(ccrcczcs!=0){"+
					"	bl  = (1 - (hlwbl + sjbl))*100;"+
					"}"+
					"if(bl>0  && bl<40){"+
					"	return \"1\";"+
					"}else if(bl>=40 && bl<80){"+
					"	return \"2\";"+
					"}else if(bl>=80 && bl<=100){"+
					"	return \"3\";"+
					"}else if(bl==0){"+
					"	return \"0\";"+
					"}"+
				"}catch(e){"+
				"	return \"-1\";"+
				"}"+
			"})(a,b,c)";
		//ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		Bindings createBindings = engine.createBindings();
		createBindings.put("a", 0.1);
		createBindings.put("b", 0.2);
		createBindings.put("c", 0.3);
		//Object eval = engine.eval(option);
		Object eval = engine.eval(option, createBindings);
		System.out.println(eval);
		System.out.println("结果类型：" + eval.getClass().getName() + ",计算结果：" + eval);
	}
	
	@Test
	public void scriptTest4() throws ScriptException, NoSuchMethodException {
		String option = "function get(a, b, c){ try{" + "var hlwbl = a - 0;" + "var sjbl = b - 0;"
				+ "var ccrcczcs = c - 0;" + "var bl  = 0;" + "if(ccrcczcs!=0){" + "bl  = (1 - (hlwbl + sjbl))*100;"
				+ "}" + "if(bl>0  && bl<40){" + "return '1';" + "}else if(bl>=40 && bl<80){" + "return '2';"
				+ "}else if(bl>=80 && bl<=100){" + "return '3';" + "}else if(bl==0){" + "return '0';" + "}"
				+ "}catch(e){" + "return '-1';" + "}}";
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");// 1.得到脚本引擎
		engine.eval(new StringReader(option));
		Invocable invocable = (Invocable) engine;
		Object eval = invocable.invokeFunction("get", "10","10","10");
		System.out.println(eval);
		//System.out.println("结果类型：" + eval.getClass().getName() + ",计算结果：" + eval);
	}
	
	@Test
	public void scriptTest5() throws ScriptException, NoSuchMethodException {
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("Nashorn");

        // String定义一个js函数
        String script = "function hello(name) { print('Hello, ' + name); }";
        // 直接执行上面的js函数（这个函数是全局的，在下面的js引擎中依然可以调用，不会执行完就消失）
        engine.eval(script);

        // javax.script.Invocable 是一个可选的接口
        // 检查脚本引擎是否被实现!
        // 注意：JavaScript engine 实现了 Invocable 接口
        Invocable inv = (Invocable) engine;

        // 执行这个名字为 "hello"的全局的函数
        inv.invokeFunction("hello", "Scripting!!" );
        
	}
	
	@Test
	public void scriptTest6() throws ScriptException, NoSuchMethodException {
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("Nashorn");

        // String定义一个js函数
        String script = "(function (name) { return 'Hello, ' + name; }(name))";
        // 直接执行上面的js函数（这个函数是全局的，在下面的js引擎中依然可以调用，不会执行完就消失）
        engine.put("name", "zhangshan");
        Object eval = engine.eval(script);
        System.out.println(eval);
        
	}
	
	@Test
	public void scriptTest7() throws ScriptException, NoSuchMethodException {
		String script = "(function (a,b){"+
							"try{\r\n"+
								"var tpzcs = a - 0;"+
								"var gpzcs = b - 0;"+
								"if(tpzcs > gpzcs){"+
									"tpzcs = gpzcs;"+
								"}"+
								"if(tpzcs>0 && tpzcs<2){"+
								"	return \"1\";"+
								"}else if(tpzcs>=2 && tpzcs<4){"+
								"	return \"2\";"+
								"}else if(tpzcs>=4){"+
								"	return \"3\";"+
								"}else if(tpzcs<=0){"+
								"	return \"0\";"+
								"}"+
							"}catch(e){"+
							"	return \"-1\";"+
							"}"+
						"})(a,b)";
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("Nashorn");
		engine.put("a", 5);
		engine.put("b", 1);
        Object eval = engine.eval(script);
        System.out.println(eval);
	}

	@Test
	public void scriptTest2() throws ScriptException {
		// js function：getRouteInfo，入参为province
		String routeScript = "function getRouteInfo(province){ \n" + // 参数不要带var。。不然后面执行方法的时候会报错。。
				"      if (province=='henan') " + "         return 'http://127.0.0.1/resweb';\n" + "      else  "
				+ "         return '未找到对应的省份信息，province='+province;\n" + "}";

		String scriptResult = "";// 脚本的执行结果

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");// 1.得到脚本引擎
		try {
			// 2.引擎读取 脚本字符串
			engine.eval(new StringReader(routeScript));
			// 如果js存在文件里，举例
			// Resource aesJs = new ClassPathResource("js/aes.js");
			// this.engine.eval(new FileReader(aesJs.getFile()));

			// 3.将引擎转换为Invocable，这样才可以掉用js的方法
			Invocable invocable = (Invocable) engine;

			// 4.使用 invocable.invokeFunction掉用js脚本里的方法，第一個参数为方法名，后面的参数为被调用的js方法的入参
			scriptResult = (String) invocable.invokeFunction("getRouteInfo", "henan");

		} catch (ScriptException e) {
			e.printStackTrace();
			System.out.println("Error executing script: " + e.getMessage() + " script:[" + routeScript + "]");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			System.out.println("Error executing script,为找到需要的方法: " + e.getMessage() + " script:[" + routeScript + "]");
		}
		System.out.println(scriptResult.toString());
	}
}
