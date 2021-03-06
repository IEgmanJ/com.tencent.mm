package ct;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class cp
  implements Parcelable, TencentLocation
{
  public static final cp a = new cp(-1);
  private cl b;
  private int c;
  private String d;
  private cj e;
  private final Bundle f = new Bundle();
  private String g = "network";
  private Location h;
  private final long i;
  private long j;
  
  static
  {
    new Parcelable.Creator() {};
  }
  
  private cp(int paramInt)
  {
    c = paramInt;
    i = SystemClock.elapsedRealtime();
    j = System.currentTimeMillis();
  }
  
  private cp(String paramString)
  {
    i = SystemClock.elapsedRealtime();
    j = System.currentTimeMillis();
    paramString = new JSONObject(paramString);
    for (;;)
    {
      try
      {
        b = new cl(paramString.getJSONObject("location"));
        d = paramString.optString("bearing");
        int k = paramString.optInt("icontrol", -1);
        if (k >= 0) {
          f.putInt("icontrol", k);
        }
        JSONObject localJSONObject = paramString.optJSONObject("details");
        if (localJSONObject != null) {}
        paramString = paramString.optJSONObject("addrdesp");
      }
      catch (JSONException paramString)
      {
        try
        {
          e = new cj(localJSONObject);
          if ((e != null) && (e.c != null)) {
            f.putAll(e.c.l);
          }
          return;
        }
        catch (JSONException paramString)
        {
          throw paramString;
        }
        paramString = paramString;
        throw paramString;
      }
      if ((paramString != null) && (paramString.has("detail"))) {
        e = new cj(paramString.optJSONObject("detail"));
      }
    }
  }
  
  public static cp a(cp paramcp, cd paramcd)
  {
    int n;
    int k;
    if ((paramcp != null) && (paramcd != null) && (d != null))
    {
      String str = d;
      int m = 0;
      n = f;
      k = m;
      if (str != null)
      {
        k = m;
        if (str.split(",").length > 1) {
          k = Integer.parseInt(str.split(",")[1]);
        }
      }
      paramcd = b;
      if (paramcd == null) {}
    }
    try
    {
      d = ((float)e.r(d, k, n));
      return paramcp;
    }
    catch (UnsatisfiedLinkError paramcd) {}
    return paramcp;
  }
  
  public static void a(cp paramcp)
  {
    if (paramcp == a) {
      throw new JSONException("location failed");
    }
  }
  
  public final void a(double paramDouble1, double paramDouble2)
  {
    b.a = (Math.round(paramDouble1 * 1000000.0D) / 1000000.0D);
    b.b = (Math.round(paramDouble2 * 1000000.0D) / 1000000.0D);
  }
  
  public final void a(Location paramLocation)
  {
    if ((paramLocation != null) && (b != null))
    {
      double d2 = paramLocation.getLatitude();
      double d1 = paramLocation.getLongitude();
      d2 = Math.round(d2 * 1000000.0D) / 1000000.0D;
      d1 = Math.round(d1 * 1000000.0D) / 1000000.0D;
      b.a = d2;
      b.b = d1;
      b.c = paramLocation.getAltitude();
      b.d = paramLocation.getAccuracy();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final float getAccuracy()
  {
    if (b != null) {
      return b.d;
    }
    return 0.0F;
  }
  
  public final String getAddress()
  {
    if (c == 5) {
      return f.getString("addrdesp.name");
    }
    if (b != null) {
      return b.f;
    }
    return "";
  }
  
  public final double getAltitude()
  {
    if (b != null) {
      return b.c;
    }
    return 0.0D;
  }
  
  public final Integer getAreaStat()
  {
    if (e != null) {
      return Integer.valueOf(e.a);
    }
    return null;
  }
  
  public final float getBearing()
  {
    if (h == null) {
      return 0.0F;
    }
    return h.getBearing();
  }
  
  public final String getCity()
  {
    if (e != null) {
      return e.c.f;
    }
    return "";
  }
  
  public final String getCityCode()
  {
    if (e != null) {
      return e.c.d;
    }
    return "";
  }
  
  public final int getCoordinateType()
  {
    return 0;
  }
  
  public final double getDirection()
  {
    if (f != null) {
      return f.getDouble("direction");
    }
    return NaN.0D;
  }
  
  public final String getDistrict()
  {
    if (e != null) {
      return e.c.g;
    }
    return "";
  }
  
  public final long getElapsedRealtime()
  {
    return i;
  }
  
  public final Bundle getExtra()
  {
    return f;
  }
  
  public final double getLatitude()
  {
    if (b != null) {
      return b.a;
    }
    return 0.0D;
  }
  
  public final double getLongitude()
  {
    if (b != null) {
      return b.b;
    }
    return 0.0D;
  }
  
  public final String getName()
  {
    if (c == 5) {
      return f.getString("addrdesp.name");
    }
    if (b != null) {
      return b.e;
    }
    return "";
  }
  
  public final String getNation()
  {
    if (e != null) {
      return e.c.b;
    }
    return "";
  }
  
  public final List<TencentPoi> getPoiList()
  {
    if (e != null) {
      return new ArrayList(e.b);
    }
    return Collections.emptyList();
  }
  
  public final String getProvider()
  {
    return g;
  }
  
  public final String getProvince()
  {
    if (e != null) {
      return e.c.e;
    }
    return "";
  }
  
  public final int getRssi()
  {
    if (h == null) {}
    Bundle localBundle;
    do
    {
      return 0;
      localBundle = h.getExtras();
    } while (localBundle == null);
    return localBundle.getInt("rssi", 0);
  }
  
  public final float getSpeed()
  {
    if (h == null) {
      return 0.0F;
    }
    return h.getSpeed();
  }
  
  public final String getStreet()
  {
    if (e != null) {
      return e.c.j;
    }
    return "";
  }
  
  public final String getStreetNo()
  {
    if (e != null) {
      return e.c.k;
    }
    return "";
  }
  
  public final long getTime()
  {
    return j;
  }
  
  public final String getTown()
  {
    if (e != null) {
      return e.c.h;
    }
    return "";
  }
  
  public final String getVillage()
  {
    if (e != null) {
      return e.c.i;
    }
    return "";
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=").append(c).append(",");
    localStringBuilder.append("name=").append(getName()).append(",");
    localStringBuilder.append("address=").append(getAddress()).append(",");
    localStringBuilder.append("provider=").append(getProvider()).append(",");
    localStringBuilder.append("latitude=").append(getLatitude()).append(",");
    localStringBuilder.append("longitude=").append(getLongitude()).append(",");
    localStringBuilder.append("altitude=").append(getAltitude()).append(",");
    localStringBuilder.append("accuracy=").append(getAccuracy()).append(",");
    localStringBuilder.append("cityCode=").append(getCityCode()).append(",");
    localStringBuilder.append("areaStat=").append(getAreaStat()).append(",");
    localStringBuilder.append("nation=").append(getNation()).append(",");
    localStringBuilder.append("province=").append(getProvince()).append(",");
    localStringBuilder.append("city=").append(getCity()).append(",");
    localStringBuilder.append("district=").append(getDistrict()).append(",");
    localStringBuilder.append("street=").append(getStreet()).append(",");
    localStringBuilder.append("streetNo=").append(getStreetNo()).append(",");
    localStringBuilder.append("town=").append(getTown()).append(",");
    localStringBuilder.append("village=").append(getVillage()).append(",");
    localStringBuilder.append("bearing=").append(getBearing()).append(",");
    localStringBuilder.append("time=").append(getTime()).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = getPoiList().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(c);
    paramParcel.writeString(getProvider());
    paramParcel.writeDouble(getLatitude());
    paramParcel.writeDouble(getLongitude());
    paramParcel.writeDouble(getAccuracy());
    paramParcel.writeDouble(getAltitude());
    paramParcel.writeString(getAddress());
    paramParcel.writeString(getNation());
    paramParcel.writeString(getProvince());
    paramParcel.writeString(getCity());
    paramParcel.writeString(getDistrict());
    paramParcel.writeString(getStreet());
    paramParcel.writeString(getStreetNo());
    if (e != null) {}
    for (String str = e.c.d;; str = "")
    {
      paramParcel.writeString(str);
      paramParcel.writeString(getName());
      paramParcel.writeLong(j);
      paramParcel.writeBundle(f);
      return;
    }
  }
  
  public static final class a
  {
    public String a;
    public cp b;
    public int c;
    public String d = "network";
    private Location e;
    
    public final a a(Location paramLocation)
    {
      e = new Location(paramLocation);
      return this;
    }
    
    public final cp a()
    {
      if (a != null) {}
      for (;;)
      {
        try
        {
          cp localcp1 = new cp(a, (byte)0);
          cp.a(cp.b(cp.a(localcp1, c), d), e);
          TencentExtraKeys.setRawGps(localcp1, e);
          return localcp1;
        }
        catch (JSONException localJSONException)
        {
          return cp.a;
        }
        cp localcp2 = cp.c(b);
      }
    }
  }
}

/* Location:
 * Qualified Name:     ct.cp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */