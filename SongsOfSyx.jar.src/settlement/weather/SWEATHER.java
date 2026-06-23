/*     */ package settlement.weather;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import game.time.TIME;
/*     */ import init.settings.S;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.color.RGB;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ 
/*     */ public final class SWEATHER
/*     */   extends SETT.SettResource
/*     */ {
/*  22 */   private final RGB.RGBImp lightColor = new RGB.RGBImp();
/*  23 */   private final WeatherDownfallRenderer rainer = new WeatherDownfallRenderer();
/*     */   
/*     */   public final WeatherMoisture moisture;
/*     */   
/*     */   public final WeatherSnow snow;
/*     */   
/*     */   public final WeatherIce ice;
/*     */   
/*     */   public final WeatherWind wind;
/*     */   
/*     */   public final WeatherTemp temp;
/*     */   public final WeatherClouds clouds;
/*     */   public final WeatherDownfall rain;
/*     */   public final WeatherThunder thunder;
/*     */   public final WeatherGrowth growth;
/*     */   public final WeatherGrowthRipe growthRipe;
/*     */   public final RainEvent downfall;
/*     */   
/*     */   public SWEATHER() {
/*  42 */     super("WEATHER", true); WeatherThing.all = new LinkedList(); this.moisture = new WeatherMoisture(); this.snow = new WeatherSnow(); this.ice = new WeatherIce(); this.wind = new WeatherWind(); this.temp = new WeatherTemp();
/*     */     this.clouds = new WeatherClouds();
/*     */     this.rain = new WeatherDownfall();
/*     */     this.thunder = new WeatherThunder();
/*     */     this.growth = new WeatherGrowth();
/*     */     this.growthRipe = new WeatherGrowthRipe();
/*  48 */     this.downfall = new RainEvent(); } protected void update(double ds, Profiler profiler) { this.lightColor.set(1.0D, 1.0D, 1.0D);
/*  49 */     if (this.temp.cold() > 0.0D && TIME.light().dayIs()) {
/*  50 */       double d = 0.2D * CLAMP.d(this.temp.cold() * 2.0D, 0.0D, 1.0D);
/*  51 */       this.lightColor.set(1.0D - d / 2.0D, 1.0D - d / 2.0D, 1.0D + d);
/*  52 */     } else if (this.temp.heat() > 0.0D && TIME.light().dayIs()) {
/*  53 */       double d = 0.3D * CLAMP.d(this.temp.heat() * 2.0D, 0.0D, 1.0D);
/*  54 */       this.lightColor.set(1.0D + d / 2.0D, 1.0D + d / 4.0D, 1.0D - d / 4.0D);
/*     */     } 
/*  56 */     this.lightColor.shade(1.0D - 0.5D * this.clouds.getD());
/*  57 */     for (WeatherThing t : WeatherThing.all) {
/*  58 */       t.update(ds);
/*     */     }
/*  60 */     this.downfall.update(ds); }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init(boolean loaded) {
/*  65 */     if (loaded)
/*     */       return; 
/*  67 */     for (WeatherThing t : WeatherThing.all)
/*  68 */       t.init(); 
/*  69 */     this.downfall.saver.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  74 */     for (WeatherThing t : WeatherThing.all)
/*  75 */       t.save(file); 
/*  76 */     this.downfall.saver.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  81 */     for (WeatherThing t : WeatherThing.all)
/*  82 */       t.load(file); 
/*  83 */     this.downfall.saver.load(file);
/*     */   }
/*     */   
/*     */   public LIST<WeatherThing> all() {
/*  87 */     return (LIST<WeatherThing>)WeatherThing.all;
/*     */   }
/*     */   
/*     */   public RGB.RGBImp lightColor() {
/*  91 */     return this.lightColor;
/*     */   }
/*     */   
/*     */   public void apply(RECTANGLE rec) {
/*  95 */     apply(rec.x1(), rec.x2(), rec.y1(), rec.y2());
/*  96 */     if ((S.get()).downpour.get() == 1)
/*  97 */       this.thunder.apply(0, 0, 0, 0); 
/*     */   }
/*     */   
/*     */   public void apply(int x1, int x2, int y1, int y2) {
/* 101 */     TIME.light().apply(x1, x2, y1, y2, (RGB)this.lightColor);
/* 102 */     if ((S.get()).downpour.get() == 1)
/* 103 */       this.thunder.apply(x1, x2, y1, y2); 
/*     */   }
/*     */   
/*     */   public void renderDownfall(Renderer r, float ds, RenderData data, int zoomout) {
/* 107 */     if ((S.get()).downpour.get() == 1)
/* 108 */       this.rainer.render(r, ds, data, zoomout); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\SWEATHER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */