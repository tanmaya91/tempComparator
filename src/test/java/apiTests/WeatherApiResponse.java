package apiTests;

import io.restassured.response.Response;

public class WeatherApiResponse
{
	private Response response;
	
    private String visibility;

    private String timezone;

    private Main main;

    private String dt;

    private String name;

    private String cod;

    private String id;

    private String base;

    private Wind wind;

    public String getVisibility ()
    {
        return visibility;
    }

    public void setVisibility (String visibility)
    {
        this.visibility = visibility;
    }

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public Main getMain ()
    {
        return main;
    }

    public void setMain (Main main)
    {
        this.main = main;
    }

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBase ()
    {
        return base;
    }

    public void setBase (String base)
    {
        this.base = base;
    }

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	@Override
    public String toString()
    {
        return "WeatherApiResponse [response = "+response+", visibility = "+visibility+", timezone = "+timezone+", main = "+main+", dt = "+dt+", name = "+name+", cod = "+cod+", id = "+id+", base = "+base+", wind = "+wind+"]";
    }
}
			