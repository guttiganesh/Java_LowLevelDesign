package LLD.ChainResponsibilityDesignPattern.Logger;

public class Main {
    public static void main(String[] args){
        LogProcessor logObj = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logObj.log(LogProcessor.ERROR,"Error Log");
        logObj.log(LogProcessor.DEBUG,"Debug Log");
        logObj.log(LogProcessor.INFO,"Info Log");
    }
}
