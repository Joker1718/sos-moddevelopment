/*     */ package init.resources;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAP;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class Minable
/*     */   implements MAPPED {
/*  27 */   private static CharSequence ¤¤minable = "¤{0} Deposits"; public final RESOURCE resource;
/*     */   static {
/*  29 */     D.ts(Minable.class);
/*     */   }
/*     */   
/*     */   public final CharSequence name;
/*     */   public final TILE_SHEET sheet;
/*     */   public final boolean onEverymap;
/*     */   public final COLOR tint;
/*     */   public final COLOR miniColor;
/*     */   public final int index;
/*     */   private final double[] terrainPref;
/*     */   public final double occurence;
/*     */   public double fertilityIncrease;
/*     */   private final String key;
/*     */   
/*     */   Minable(String key, int index, TILE_SHEET sheet, Json json) {
/*  44 */     this.onEverymap = json.bool("ON_EVERY_MAP");
/*  45 */     this.tint = (COLOR)new ColorImp(json);
/*  46 */     this.miniColor = (COLOR)new ColorImp(json, "MINIMAP_COLOR");
/*  47 */     this.fertilityIncrease = json.d("FERTILITY_INCREASE", -1.0D, 1.0D);
/*  48 */     this.sheet = sheet;
/*  49 */     this.index = index;
/*  50 */     this.resource = (RESOURCE)RESOURCES.map().read(json);
/*  51 */     this.name = (CharSequence)(new Str(¤¤minable)).insert(0, this.resource.name).trim();
/*  52 */     this.terrainPref = TERRAINS.MAP().readFill(json, 1.0D);
/*  53 */     double mm = 0.0D; byte b; int j; double[] arrayOfDouble;
/*  54 */     for (j = (arrayOfDouble = this.terrainPref).length, b = 0; b < j; ) { double d = arrayOfDouble[b];
/*  55 */       mm += d; b++; }
/*     */     
/*  57 */     for (int i = 0; i < this.terrainPref.length; i++) {
/*  58 */       this.terrainPref[i] = this.terrainPref[i] / mm;
/*     */     }
/*     */ 
/*     */     
/*  62 */     this.occurence = json.dTry("OCCURENCE", 0.0D, 1000.0D, 1.0D);
/*  63 */     this.key = key;
/*     */   }
/*     */ 
/*     */   
/*     */   static RMAP<Minable> make(PATH pathData, PATH pathSprites) throws IOException {
/*  68 */     String folder = "minable";
/*     */     
/*  70 */     PATH pd = pathData.getFolder(folder);
/*  71 */     PATH ps = pathSprites.getFolder(folder);
/*  72 */     HashMap<String, TILE_SHEET> spriteMap = new HashMap<>();
/*     */     
/*  74 */     Util util = new Util();
/*  75 */     String[] files = pd.getFiles(1, 31);
/*  76 */     ArrayList<Minable> res = new ArrayList(files.length); byte b; int i;
/*     */     String[] arrayOfString1;
/*  78 */     for (i = (arrayOfString1 = files).length, b = 0; b < i; ) { String p = arrayOfString1[b];
/*  79 */       Json j = new Json(pd.gets(p));
/*  80 */       String sprite = j.value("SPRITE");
/*  81 */       if (!spriteMap.containsKey(sprite)) {
/*  82 */         if (!ps.exists(sprite)) {
/*     */           
/*  84 */           String er = "Could not find texture file named: " + sprite + " Found only: " + System.lineSeparator();
/*  85 */           for (Map.Entry<String, TILE_SHEET> e : spriteMap.entrySet()) {
/*  86 */             er = er + er + System.lineSeparator();
/*     */           }
/*  88 */           j.error(er, sprite);
/*     */         } 
/*  90 */         spriteMap.put(sprite, util.sprite(ps.get(sprite)));
/*     */       } 
/*     */       
/*  93 */       Minable g = new Minable(p, res.size(), spriteMap.get(sprite), j);
/*  94 */       res.add(g);
/*     */       b++; }
/*     */     
/*  97 */     return new RMAP("MINABLE", (LIST)res);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class Util
/*     */   {
/*     */     private TILE_SHEET sprite(Path path) throws IOException {
/* 109 */       return (new ComposerThings.ITileSheet(path, 364, 94)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 113 */             s.singles.init(0, 0, 1, 1, 8, 2, (ComposerDests.Dest)d.s16);
/* 114 */             s.singles.paste(1, true);
/* 115 */             return d.s16.saveGame();
/*     */           }
/* 117 */         }).get();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int index() {
/* 124 */     return this.index;
/*     */   }
/*     */   
/*     */   public double terrain(TERRAIN t) {
/* 128 */     return this.terrainPref[t.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 133 */     return this.key;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\Minable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */