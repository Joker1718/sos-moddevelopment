/*     */ package init.race.appearence;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ final class RPortraitFrame
/*     */ {
/*     */   private final LIST<RaceFrameRaw> frames;
/*     */   private final int random;
/*     */   final int occurence;
/*     */   private int dx;
/*     */   private int dy;
/*     */   private int dxr;
/*     */   private int dyr;
/*     */   private final RColors.ColorCollection color;
/*     */   private final int opacity;
/*  30 */   private static final OpacityImp op = new OpacityImp(0);
/*     */   
/*     */   public final boolean stains;
/*     */   
/*  34 */   public final Lockable<Induvidual> cons = GVALUES.INDU.LOCK.push();
/*     */ 
/*     */   
/*  37 */   private static KeyMap<String> keepClean = new KeyMap();
/*     */   static {
/*  39 */     String[] keep = { 
/*  40 */         "FRAMES", 
/*  41 */         "FRAME_RANDOM", 
/*  42 */         "FRAME_OCCURENCE", 
/*  43 */         "OFF_X", 
/*  44 */         "OFF_Y", 
/*  45 */         "OFF_X_RANDOM", 
/*  46 */         "OFF_Y_RANDOM", 
/*  47 */         "CONDITIONS", 
/*  48 */         "COLOR", 
/*  49 */         "OPACITY", 
/*  50 */         "STAINS" }; byte b;
/*     */     int i;
/*     */     String[] arrayOfString1;
/*  53 */     for (i = (arrayOfString1 = keep).length, b = 0; b < i; ) { String s = arrayOfString1[b];
/*  54 */       keepClean.put(s, s);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   RPortraitFrame(RaceFrameMaker fm, RColors colors, Json json, int i) throws IOException {
/*  61 */     for (String s : json.keys()) {
/*  62 */       if (!keepClean.containsKey(s)) {
/*  63 */         GAME.Warn(json.errorGet(s + " is not a valid modifier, available:  " + s, s));
/*     */       }
/*     */     } 
/*     */     
/*  67 */     this.frames = fm.read(json);
/*  68 */     this.random = json.has("FRAME_RANDOM") ? json.i("FRAME_RANDOM", 0, 16) : (i % 16);
/*  69 */     this.occurence = (int)(16.0D * (json.has("FRAME_OCCURRENCE") ? json.d("FRAME_OCCURRENCE", 0.0D, 1.0D) : 1.0D));
/*  70 */     this.dx = json.has("OFF_X") ? json.i("OFF_X", -40, 40) : 0;
/*  71 */     this.dy = json.has("OFF_Y") ? json.i("OFF_Y", -48, 48) : 0;
/*  72 */     this.dxr = json.has("OFF_X_RANDOM") ? json.i("OFF_X_RANDOM", 0, 40) : 0;
/*  73 */     this.dyr = json.has("OFF_Y_RANDOM") ? json.i("OFF_Y_RANDOM", 0, 48) : 0;
/*  74 */     this.cons.push("CONDITIONS", json);
/*     */ 
/*     */ 
/*     */     
/*  78 */     this.color = json.has("COLOR") ? (RColors.ColorCollection)colors.collection.get(json.value("COLOR"), json) : RColors.dummy;
/*  79 */     this.opacity = json.has("OPACITY") ? json.i("OPACITY", 0, 256) : 255;
/*  80 */     this.stains = json.has("STAINS") ? json.bool("STAINS") : true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1, Induvidual indu, int scale) {
/*  86 */     if (this.frames.size() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  91 */     if (!this.cons.passes(indu)) {
/*     */       return;
/*     */     }
/*  94 */     int ran = STATS.RAN().get(indu, this.random * 16) & 0xFF;
/*  95 */     if (this.occurence <= (ran & 0xF)) {
/*     */       return;
/*     */     }
/*     */     
/*  99 */     COLOR col = this.color.get(indu, ((STATS.APPEARANCE()).dead.indu().get(indu) == 1));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     ColorImp colorImp = ColorImp.TMP.set(col).shadeSelf(1.2D);
/*     */     
/* 112 */     colorImp.bind();
/* 113 */     op.set(this.opacity);
/* 114 */     op.bind();
/*     */     
/* 116 */     x1 = (int)(x1 + (this.dx + ran / 15.0D * this.dxr) * scale);
/* 117 */     y1 = (int)(y1 + (this.dy + (ran >> 4) / 15.0D * this.dyr) * scale);
/*     */ 
/*     */ 
/*     */     
/* 121 */     int var = ran % this.frames.size();
/*     */     
/* 123 */     ((RaceFrameRaw)this.frames.get(var)).render(r, x1, y1, scale);
/* 124 */     COLOR.unbind();
/* 125 */     OPACITY.unbind();
/*     */     
/* 127 */     if (this.stains)
/* 128 */       ((RaceFrameRaw)this.frames.get(var)).renderOverlay(r, x1, y1, scale, (STATS.NEEDS()).INJURIES.COUNT.indu().getD(indu), STATS.NEEDS().grime(indu), (indu.race().appearance()).colors.blood); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RPortraitFrame.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */