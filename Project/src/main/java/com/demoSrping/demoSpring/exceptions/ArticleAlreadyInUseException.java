package com.demoSrping.demoSpring.exceptions;

import com.demoSrping.demoSpring.entity.Article;

public class ArticleAlreadyInUseException extends RuntimeException{

    public ArticleAlreadyInUseException(Article article){
        super("Article: " + article + " already IN USE");
    }

}
