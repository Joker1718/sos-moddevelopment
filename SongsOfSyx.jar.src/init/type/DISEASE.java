/*     */ package init.type;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class DISEASE
/*     */   implements MAPPED {
/*     */   private final int index;
/*     */   public final INFO info;
/*     */   public final String key;
/*     */   public final double infectRate;
/*     */   public final double incubationDays;
/*     */   public final double fatalityRate;
/*  25 */   private final double[] coccurence = new double[CLIMATES.ALL().size()];
/*  26 */   private final double[] toccurence = new double[TERRAINS.ALL().size()];
/*     */   
/*     */   public final int length;
/*     */   public final COLOR color;
/*     */   public final boolean epidemic;
/*     */   public final boolean regular;
/*  32 */   private static CharSequence ¤¤Spread = "Spread";
/*  33 */   private static CharSequence ¤¤Occurrence = "Occurrence";
/*  34 */   private static CharSequence ¤¤Incubation = "Incubation Days";
/*  35 */   private static CharSequence ¤¤Length = "Infection Days";
/*  36 */   private static CharSequence ¤¤Lethality = "lethality";
/*     */   
/*     */   static {
/*  39 */     D.ts(DISEASE.class);
/*     */   }
/*     */ 
/*     */   
/*     */   DISEASE(LISTE<DISEASE> all, String key, Json data, Json text) {
/*  44 */     this.index = all.add(this);
/*  45 */     this.key = key;
/*  46 */     this.info = new INFO(text);
/*     */     
/*  48 */     this.infectRate = data.d("SPREAD", 0.0D, 1.0D);
/*  49 */     this.incubationDays = data.i("INCUBATION_DAYS", 1, 100);
/*  50 */     this.fatalityRate = data.d("FATALITY_RATE", 0.0D, 1.0D);
/*  51 */     CLIMATES.MAP().readFill("OCCURRENCE_CLIMATE", this.coccurence, data, 0.0D, 100000.0D);
/*  52 */     TERRAINS.MAP().readFill("OCCURRENCE_TERRAIN", this.toccurence, data, 0.0D, 100000.0D);
/*  53 */     this.length = data.i("INFECTION_DAYS", 1, 100);
/*  54 */     this.epidemic = data.bool("EPIDEMIC");
/*  55 */     this.regular = data.bool("REGULAR");
/*  56 */     this.color = (COLOR)(new ColorImp(data)).shade(2.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  61 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  66 */     return this.key;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text) {
/*  71 */     GBox b = (GBox)text;
/*  72 */     this.info.hover((GUI_BOX)b);
/*     */ 
/*     */ 
/*     */     
/*  76 */     double occ = 0.0D;
/*     */     
/*  78 */     b.NL();
/*  79 */     b.textLL(¤¤Occurrence);
/*  80 */     b.NL();
/*  81 */     int tt = 0;
/*     */     
/*  83 */     for (TERRAIN t : TERRAINS.ALL()) {
/*  84 */       occ += this.toccurence[t.index()] * (SETT.WORLD_AREA()).info.get(t).getD();
/*  85 */       if (tt > 6) {
/*  86 */         tt = 0;
/*  87 */         b.NL();
/*     */       } 
/*  89 */       b.add(t.icon());
/*  90 */       b.add((SPRITE)GFORMAT.f0(b.text(), this.toccurence[t.index()]));
/*     */     } 
/*  92 */     b.NL();
/*  93 */     CLIMATE climate = SETT.ENV().climate();
/*  94 */     occ *= this.coccurence[climate.index()];
/*  95 */     b.textLL((CLIMATES.INFO()).name);
/*  96 */     b.tab(6);
/*  97 */     b.add((SPRITE)GFORMAT.f0(b.text(), this.coccurence[climate.index()]));
/*  98 */     b.NL();
/*  99 */     b.textSLL(Dic.¤¤Total);
/* 100 */     b.tab(6);
/* 101 */     b.add((SPRITE)GFORMAT.f0(b.text(), occ));
/*     */     
/* 103 */     b.sep();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 108 */     b.NL();
/* 109 */     b.textLL(¤¤Spread);
/* 110 */     b.tab(6);
/* 111 */     b.add((SPRITE)GFORMAT.percInv(b.text(), this.infectRate));
/* 112 */     b.NL();
/*     */     
/* 114 */     b.textLL(¤¤Incubation);
/* 115 */     b.tab(6);
/* 116 */     b.add((SPRITE)GFORMAT.f(b.text(), this.incubationDays, 1));
/* 117 */     b.NL();
/*     */     
/* 119 */     b.textLL(¤¤Length);
/* 120 */     b.tab(6);
/* 121 */     b.add((SPRITE)GFORMAT.f(b.text(), this.length, 1));
/* 122 */     b.NL();
/*     */     
/* 124 */     b.NL(8);
/* 125 */     b.textLL(¤¤Lethality);
/* 126 */     b.tab(6);
/* 127 */     b.add((SPRITE)GFORMAT.percInv(b.text(), this.fatalityRate));
/*     */     
/* 129 */     b.sep();
/*     */   }
/*     */ 
/*     */   
/*     */   public double occurence() {
/* 134 */     double occ = 0.0D;
/*     */     
/* 136 */     for (TERRAIN t : TERRAINS.ALL()) {
/* 137 */       occ = Math.max(occ, this.toccurence[t.index()] * (SETT.WORLD_AREA()).info.get(t).getD());
/*     */     }
/* 139 */     CLIMATE climate = SETT.ENV().climate();
/* 140 */     occ *= this.coccurence[climate.index()];
/* 141 */     return occ;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 146 */     return this.key;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\DISEASE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */