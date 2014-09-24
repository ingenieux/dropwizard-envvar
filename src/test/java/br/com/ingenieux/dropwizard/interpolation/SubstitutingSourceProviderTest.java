package br.com.ingenieux.dropwizard.interpolation;

import org.apache.commons.lang.text.StrLookup;
import org.apache.commons.lang.text.StrSubstitutor;
import org.junit.Test;

import java.io.IOException;

import static br.com.ingenieux.dropwizard.interpolation.SubstitutingSourceProvider.convertStreamToString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubstitutingSourceProviderTest
{
	StrLookup dummyLookup = new StrLookup()
	{
		@Override
		public String lookup( String s )
		{
			return "baz";
		}
	};

	@Test
	public void shouldSubstituteCorrectly() throws IOException
	{
		SubstitutingSourceProvider preprocessor = new SubstitutingSourceProvider( new DummySourceProvider(), new StrSubstitutor( dummyLookup ) );
		String results = convertStreamToString( preprocessor.open( "foo: ${bar}" ) );

		assertThat( results, is( "foo: baz" ) );
	}
}
