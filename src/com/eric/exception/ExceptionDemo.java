package com.eric.exception;

/**
 * @author xizhijin
 * 异常抛出顺序：testEx2-》testEx1-》testEx0-》main
 */
public class ExceptionDemo {  
    
	public ExceptionDemo() {  
    }  
  
    boolean testEx0() {  
        boolean ret = true;  
        try {  
            ret = testEx1(); 
        } catch (Exception e) {  
            System.out.println("testEx0, catch exception");  
            ret = false;
            throw e;  
        } finally {  
            System.out.println("testEx0, finally; return value=" + ret);  
        }
        return ret;
    }  
  
    boolean testEx1() {  
        boolean ret = true;  
        try {  
            ret = testEx2();  
            if (!ret) {  
                return false;  
            }  
            System.out.println("testEx1, at the end of try");  
        } catch (Exception e) {  
            System.out.println("testEx1, catch exception");  
            ret = false;  
            throw e;  
        } finally {  
            System.out.println("testEx1, finally; return value=" + ret);  
        }  
        return ret;  
    }  
  
    boolean testEx2() {  
        boolean ret = true;  
        try {  
            int b = 12;  
            for (int i = 2; i >= 0; i--) {  
                int c = b / i;  
                System.out.println("c=" + c);  
            }  
        } catch (Exception e) {  
            System.out.println("testEx2, catch exception");  
            ret = false;  
            throw e;  
        } finally {  
            System.out.println("testEx2, finally; return value=" + ret);  
        }  
        return true;  
    }  
    
    public static int test() {
    	int i = 0;
    	try {
    		i = 1;
    		return i;
    	} finally {
    		i = 5;
    	}
    }
    
    public static void main(String[] args) {  
    	ExceptionDemo demo = new ExceptionDemo();  
        try {  
            System.out.println(demo.testEx0());
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("程序正常終止");
    	/*System.out.println(test());*/
    }  
    
}  
