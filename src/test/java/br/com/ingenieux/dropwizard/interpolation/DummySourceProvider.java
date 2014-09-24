package br.com.ingenieux.dropwizard.interpolation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import io.dropwizard.configuration.ConfigurationSourceProvider;

class DummySourceProvider implements ConfigurationSourceProvider
{
	@Override
	public InputStream open( String textToReturn ) throws IOException
	{
		return new ByteArrayInputStream( textToReturn.getBytes() );
	}
}