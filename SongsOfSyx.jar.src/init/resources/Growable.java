/*     */ package init.resources;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import java.io.IOException;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public final class Growable
/*     */   extends ResG
/*     */ {
/*     */   public final double seasonalOffset;
/*     */   public final double growthValue;
/*     */   public final COLOR colorMinimap;
/*     */   private final double[] climate;
/*     */   public final GrowableSprite sprite;
/*     */   
/*     */   private Growable(String key, int index, Json json, KeyMap<TILE_SHEET> sheetMap) throws IOException {
/*  29 */     super(index, key, (RESOURCE)RESOURCES.map().read(json));
/*  30 */     this.seasonalOffset = json.d("SEASONAL_OFFSET", 0.0D, 1.0D);
/*  31 */     this.growthValue = json.d("GROWTH_VALUE", 0.0D, 1.0D);
/*  32 */     this.colorMinimap = (COLOR)new ColorImp(json, "MINIMAP_COLOR");
/*  33 */     this.climate = new double[CLIMATES.ALL().size()];
/*  34 */     CLIMATES.MAP().readFill("CLIMATE_BONUS", this.climate, json, 0.0D, 10000.0D);
/*     */ 
/*     */     
/*  37 */     json = json.json("SPRITE");
/*     */ 
/*     */     
/*  40 */     double poll = json.d("POLLEN", 0.0D, 10.0D);
/*  41 */     double wind = json.dTry("WIND_SWAY", 0.0D, 10.0D, 1.0D);
/*     */     
/*  43 */     this.sprite = new GrowableSprite(json.value("SPRITE"), wind, poll, sheetMap);
/*     */     
/*  45 */     this.sprite.setPollenColor((COLOR)new ColorImp(json, "COLOR_POLLEN"));
/*     */     
/*  47 */     set(json.json("STEM"), this.sprite.trunk);
/*  48 */     set(json.json("GROWTH"), this.sprite.growth);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void set(Json json, GrowableSprite.Part part) {
/*  55 */     part.sheightoverGround = json.d("SHADOW_HEIGHT", 0.0D, 32.0D);
/*  56 */     part.sheight = json.d("SHADOW_LENGTH", 0.0D, 32.0D);
/*  57 */     part.setColors((COLOR)new ColorImp(json, "DEAD"), (COLOR)new ColorImp(json, "LIVE"), (COLOR)new ColorImp(json, "RIPE"));
/*  58 */     if (json.has("WIND_SWAY")) {
/*  59 */       part.sway = json.d("WIND_SWAY", 0.0D, 10.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, ShadowBatch shadowBatch, RenderData.RenderIterator it, int amount, boolean ripe) {}
/*     */   
/*     */   public double availability(CLIMATE c) {
/*  67 */     return this.climate[c.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   static GrowableGroup make(PATH pathData, PATH pathSprites) throws IOException {
/*  72 */     String folder = "growable";
/*  73 */     PATH pd = pathData.getFolder(folder);
/*     */ 
/*     */     
/*  76 */     KeyMap<TILE_SHEET> sheetMap = new KeyMap();
/*  77 */     String[] files = pd.getFiles();
/*  78 */     ArrayList<Growable> res = new ArrayList(files.length); byte b; int i;
/*     */     String[] arrayOfString1;
/*  80 */     for (i = (arrayOfString1 = files).length, b = 0; b < i; ) { String p = arrayOfString1[b];
/*  81 */       Json j = new Json(pd.gets(p));
/*  82 */       Growable g = new Growable(p, res.size(), j, sheetMap);
/*  83 */       res.add(g);
/*     */       b++; }
/*     */     
/*  86 */     return new GrowableGroup(sheetMap, res);
/*     */   }
/*     */   
/*     */   public static class GrowableGroup
/*     */     extends ResGroup<Growable>
/*     */   {
/*     */     private final KeyMap<TILE_SHEET> sheetMap;
/*     */     
/*     */     GrowableGroup(KeyMap<TILE_SHEET> sheetMap, ArrayList<Growable> res) {
/*  95 */       super("GROWABLE", (LIST<Growable>)res);
/*  96 */       this.sheetMap = sheetMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public GrowableSprite sprite(String ssheet, double wind, double pollen) throws IOException {
/* 101 */       return new GrowableSprite(ssheet, wind, pollen, this.sheetMap);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\Growable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */