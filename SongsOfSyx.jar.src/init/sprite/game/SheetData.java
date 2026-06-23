/*     */ package init.sprite.game;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ public final class SheetData
/*     */ {
/*  13 */   public double FPS = 0.0D;
/*  14 */   private int FPS_INTERVAL = 64;
/*  15 */   public int shadowLength = 0;
/*  16 */   public int shadowHeight = 0;
/*     */   
/*     */   public boolean rotates = false;
/*     */   public final LIST<COLOR> colors;
/*     */   public boolean circular = false;
/*     */   private static final double RANI = 0.00392156862745098D;
/*  22 */   private static final ArrayList<COLOR> onlyWhite = new ArrayList(COLOR.WHITE100);
/*  23 */   private static final ArrayList<COLOR> shades = new ArrayList(48);
/*     */   
/*     */   static {
/*  26 */     for (int i = 0; i < 48; i++) {
/*  27 */       int d = i / 3;
/*  28 */       int q = i % 3;
/*  29 */       shades.add(new ColorImp(127 - d * 2 - 4 * (q & 0x1), 127 - d * 2 - 4 * (q >> 1 & 0x1), 127 - d * 2 - 4 * (q >> 2 & 0x1)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  34 */   public static SheetData DUMMY = new SheetData();
/*     */   
/*     */   public SheetData() {
/*  37 */     this.colors = (LIST<COLOR>)shades;
/*     */   }
/*     */   private static KeyMap<String> oks;
/*     */   public SheetData(Json json) {
/*  41 */     test(json);
/*  42 */     this.FPS = json.dTry("FPS", 0.0D, 100000.0D, 0.0D);
/*  43 */     this.FPS_INTERVAL = (int)(64.0D * json.dTry("FPS_INTERVAL", 0.0D, 1.0D, 1.0D));
/*     */     
/*  45 */     this.shadowLength = (int)json.dTry("SHADOW_LENGTH", 0.0D, 100.0D, this.shadowLength);
/*  46 */     this.shadowHeight = (int)json.dTry("SHADOW_HEIGHT", 0.0D, 100.0D, this.shadowHeight);
/*  47 */     this.circular = json.bool("CIRCULAR", false);
/*  48 */     this.rotates = json.bool("ROTATES", true);
/*  49 */     if (json.has("COLOR")) {
/*  50 */       this.colors = (LIST<COLOR>)new ArrayList((Iterable)ColorImp.cols(json, "COLOR"));
/*  51 */     } else if (json.bool("TINT", true)) {
/*  52 */       this.colors = (LIST<COLOR>)shades;
/*     */     } else {
/*  54 */       this.colors = (LIST<COLOR>)onlyWhite;
/*     */     } 
/*     */   }
/*     */   SheetData(SheetData def, Json json) {
/*  58 */     test(json);
/*  59 */     this.FPS = json.dTry("FPS", 0.0D, 100000.0D, def.FPS);
/*  60 */     this.FPS_INTERVAL = (int)(64.0D * json.dTry("FPS_INTERVAL", 0.0D, 1.0D, def.FPS_INTERVAL / 64.0D));
/*  61 */     this.shadowLength = (int)json.dTry("SHADOW_LENGTH", 0.0D, 100.0D, def.shadowLength);
/*  62 */     this.shadowHeight = (int)json.dTry("SHADOW_HEIGHT", 0.0D, 100.0D, def.shadowHeight);
/*  63 */     this.circular = json.bool("CIRCULAR", def.circular);
/*  64 */     this.rotates = json.bool("ROTATES", def.rotates);
/*  65 */     if (json.has("COLOR")) {
/*  66 */       this.colors = (LIST<COLOR>)new ArrayList((Iterable)ColorImp.cols(json, "COLOR"));
/*  67 */     } else if (json.bool("TINT", true)) {
/*  68 */       this.colors = (LIST<COLOR>)shades;
/*     */     } else {
/*  70 */       this.colors = def.colors;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void test(Json json) {
/*  76 */     if (oks == null) {
/*  77 */       oks = new KeyMap();
/*  78 */       oks.put("FPS", "animation speed");
/*  79 */       oks.put("FPS_INTERVAL", "animate consistently");
/*  80 */       oks.put("SHADOW_LENGTH", "length shadow");
/*  81 */       oks.put("SHADOW_HEIGHT", "height shadow");
/*  82 */       oks.put("CIRCULAR", "animation circular");
/*  83 */       oks.put("ROTATES", "rotates");
/*  84 */       oks.put("COLOR", "color, or colors");
/*  85 */       oks.put("TINT", "tint sprite randomly");
/*  86 */       oks.put("FRAMES", "farmes spec");
/*  87 */       oks.put("OVERWRITE", "special stuff");
/*  88 */       oks.put("RESOURCES", "special stuff");
/*     */     } 
/*     */     
/*  91 */     for (String k : json.keys()) {
/*  92 */       if (!oks.containsKey(k)) {
/*  93 */         String av = "";
/*  94 */         for (String kk : oks.keys()) {
/*  95 */           av = av + av + " (" + kk + "), ";
/*     */         }
/*  97 */         json.error(k + " is not a valid key in a sprite json. Available: " + k, k);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int frame(int random, double animationSpeed) {
/* 103 */     double frame = (random >> 8);
/* 104 */     animationSpeed *= this.FPS;
/* 105 */     if (animationSpeed <= 0.0D) {
/* 106 */       return (int)frame;
/*     */     }
/*     */     
/* 109 */     frame += TIME.currentSecond() * animationSpeed;
/*     */     
/* 111 */     frame += (random >> 16 & 0xFF) * 0.00392156862745098D;
/*     */     
/* 113 */     if (this.FPS_INTERVAL == 64)
/* 114 */       return (int)frame; 
/* 115 */     int fi = (int)frame + (random >>> 24) & 0x3F;
/* 116 */     fi -= this.FPS_INTERVAL;
/* 117 */     if (fi > 0) {
/* 118 */       frame -= fi;
/*     */     }
/* 120 */     return (int)frame;
/*     */   }
/*     */   
/*     */   public COLOR color(int random) {
/* 124 */     return (COLOR)this.colors.getC(random);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\game\SheetData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */