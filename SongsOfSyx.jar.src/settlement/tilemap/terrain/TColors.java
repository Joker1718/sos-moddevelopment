/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TColors
/*     */ {
/*     */   public final Tree tree;
/*     */   public final Minimap minimap;
/*     */   public final COLOR waternormal;
/*     */   public final COLOR waterWinter;
/*     */   
/*     */   public TColors() throws IOException {
/*  27 */     Json j = new Json((PATHS.CONFIG()).init.gets("SettColors"));
/*  28 */     this.tree = new Tree();
/*  29 */     this.minimap = new Minimap(j);
/*  30 */     j = j.json("WATER");
/*  31 */     this.waternormal = (COLOR)new ColorImp(j, "NORMAL");
/*  32 */     this.waterWinter = (COLOR)new ColorImp(j, "WINTER");
/*     */   }
/*     */   
/*     */   void update(double ds) {
/*  36 */     this.tree.update(ds);
/*     */   }
/*     */   
/*     */   void init() {
/*  40 */     this.tree.update(4.0D);
/*     */   }
/*     */   
/*     */   final class Tree
/*     */   {
/*  45 */     private final ColorImp[] cols = new ColorImp[64];
/*     */ 
/*     */     
/*     */     public final LIST<COLOR> fertile;
/*     */ 
/*     */     
/*     */     private final LIST<COLOR> dry;
/*     */ 
/*     */     
/*     */     private final LIST<COLOR> autumn;
/*     */ 
/*     */     
/*     */     private final LIST<COLOR> winter;
/*     */     
/*     */     private double time;
/*     */     
/*     */     private final ColorImp c1;
/*     */     
/*     */     private final ColorImp c2;
/*     */ 
/*     */     
/*     */     private LIST<COLOR> row(final int row) throws IOException {
/*  67 */       LIST<COLOR> cc = (new ComposerThings.IColorSampler()
/*     */         {
/*     */           protected COLOR next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/*  71 */             s.full.setSkip(1, row * 16 + i);
/*  72 */             return s.full.sample();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*  77 */             s.full.init(0, 0, 1, 1, 16, 4, d.s16);
/*  78 */             return 16;
/*     */           }
/*  80 */         }).getHalf();
/*     */       
/*  82 */       ArrayList<COLOR> nn = new ArrayList(this.cols.length);
/*     */       
/*  84 */       for (int i = 0; i < this.cols.length; i++) {
/*  85 */         ColorImp colorImp; COLOR c = (COLOR)cc.getC(i);
/*  86 */         if (i >= nn.size())
/*  87 */           colorImp = (new ColorImp(c)).shadeSelf(RND.rFloat1(0.1D)); 
/*  88 */         nn.add(colorImp);
/*     */       } 
/*  90 */       return (LIST<COLOR>)nn;
/*     */     }
/*     */     
/*     */     Tree() throws IOException
/*     */     {
/*  95 */       this.time = 0.0D;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 124 */       this.c1 = new ColorImp();
/* 125 */       this.c2 = new ColorImp(); for (int i = 0; i < this.cols.length; i++)
/*     */         this.cols[i] = new ColorImp();  this.fertile = row(0); this.dry = row(1);
/*     */       this.autumn = row(2);
/* 128 */       this.winter = row(3); } private void set(int i, double autumn, double winter, double dry) { this.c1.interpolate((COLOR)this.fertile.get(i), (COLOR)this.autumn.get(i), autumn);
/* 129 */       this.c2.interpolate((COLOR)this.c1, (COLOR)this.winter.get(i), winter);
/* 130 */       this.cols[i].interpolate((COLOR)this.c2, (COLOR)this.dry.get(i), dry); }
/*     */     void update(double ds) { this.time -= ds; if (this.time > 0.0D)
/*     */         return;  this.time += 2.0D; double moist = (SETT.WEATHER()).moisture.getD(); if (moist < 0.5D) { moist /= 0.5D; } else { moist = 1.0D; }  double winter = 1.0D - (SETT.WEATHER()).growth.getD(); double autumn = 0.0D; if (winter <= 0.5D && (SETT.WEATHER()).growth.isAutumn()) { autumn = Math.pow(winter * 2.0D, 0.5D); winter = 0.0D; } else if (winter > 0.5D) { autumn = (SETT.WEATHER()).growth.isAutumn() ? 1.0D : 0.0D; winter = (winter - 0.5D) * 2.0D; moist += winter; }
/*     */        for (int i = 0; i < this.cols.length; i++)
/* 134 */         set(i, autumn, winter, 1.0D - moist);  } public COLOR get(int ran) { return (COLOR)this.cols[ran & 0x3F]; }
/*     */ 
/*     */     
/*     */     public COLOR def() {
/* 138 */       return (COLOR)this.fertile.get(0);
/*     */     }
/*     */     
/*     */     public COLOR dry(int ran) {
/* 142 */       return (COLOR)this.dry.getC(ran);
/*     */     }
/*     */     
/*     */     public COLOR winter(int ran) {
/* 146 */       return (COLOR)this.winter.getC(ran);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final class Minimap
/*     */   {
/*     */     public final COLOR tree;
/*     */     public final COLOR water;
/*     */     public final COLOR water_deep;
/*     */     public final COLOR rock;
/*     */     public final COLOR growable;
/*     */     public final COLOR mountain;
/*     */     
/*     */     private Minimap(Json j) throws IOException {
/* 161 */       j = j.json("MINIMAP");
/* 162 */       this.tree = (COLOR)(new ColorImp(j, "TREE")).shadeSelf(2.0D);
/* 163 */       this.water = (COLOR)(new ColorImp(j, "WATER")).shadeSelf(2.0D);
/* 164 */       this.water_deep = (COLOR)(new ColorImp(j, "WATER_DEEP")).shadeSelf(2.0D);
/* 165 */       this.rock = (COLOR)(new ColorImp(j, "ROCK")).shadeSelf(2.0D);
/* 166 */       this.growable = (COLOR)(new ColorImp(j, "GROWABLE")).shadeSelf(2.0D);
/* 167 */       this.mountain = (COLOR)(new ColorImp(j, "MOUNTAIN")).shadeSelf(2.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final class Water
/*     */   {
/*     */     public final COLOR normal;
/*     */ 
/*     */     
/*     */     public final COLOR winterMask;
/*     */ 
/*     */     
/*     */     private Water(Json j) throws IOException {
/* 182 */       j = j.json("WATER");
/* 183 */       this.normal = (COLOR)new ColorImp(j, "NORMAL");
/* 184 */       this.winterMask = (COLOR)new ColorImp(j, "WINTER_MASK");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TColors.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */