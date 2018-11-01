package com.scnetcracker.parse;

import java.io.IOException;

public abstract interface Parser
{
  public abstract void parse(String paramString)
    throws IOException;
}
