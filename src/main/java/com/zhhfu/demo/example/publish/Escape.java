package com.zhhfu.demo.example.publish;

import com.zhhfu.demo.annotations.NotRecommend;
import com.zhhfu.demo.annotations.UnSafeThread;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@UnSafeThread
@NotRecommend
public class Escape {
    private int thisCanbeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}",Escape.this.thisCanbeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
