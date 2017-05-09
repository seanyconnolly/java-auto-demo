package io.shaneconnolly.java.auto.demo.framework;

import cucumber.api.Scenario;
import lombok.Data;

import java.util.Collection;


@Data
public class SCScenario implements Scenario {

    public SCScenario(Scenario scenario){
        super();
        this.scenario = scenario;
    }

    Scenario scenario;

    boolean isPassed;

    boolean isError;

    @Override
    public Collection<String> getSourceTagNames() {
        return this.getSourceTagNames();
    }

    @Override
    public String getStatus() {
        return this.getStatus();
    }

    @Override
    public boolean isFailed() {
        return this.isFailed();
    }

    @Override
    public void embed(byte[] bytes, String s) {
        this.embed(bytes,s);
    }

    @Override
    public void write(String s) {
        this.write(s);
    }

    @Override
    public String getName() {
        return this.getName();
    }

    @Override
    public String getId() {
        return this.getId();
    }

    public boolean isPassed(){
        return this.isPassed;
    }

    public boolean isError(){
        return this.isError;
    }
}
