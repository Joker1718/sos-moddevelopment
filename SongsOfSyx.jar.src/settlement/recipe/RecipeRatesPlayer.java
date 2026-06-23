/*     */ package settlement.recipe;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.MapIntInt;
/*     */ 
/*     */ public class RecipeRatesPlayer
/*     */ {
/*  29 */   private final MapIntInt mapBo = new MapIntInt();
/*  30 */   private final ArrayListGrower<Data> boData = new ArrayListGrower();
/*     */   
/*  32 */   private final double[] best = new double[TR.ALL().size()];
/*  33 */   private final double[] bestTotal = new double[TR.ALL().size()];
/*  34 */   private final Recipe[] bestR = new Recipe[TR.ALL().size()];
/*     */   private final double[] rateTot;
/*  36 */   int tt = 0;
/*     */   
/*  38 */   private int rateI = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Recipes recp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double rateTotal(TRADABLE res) {
/*  66 */     calc();
/*  67 */     return this.bestTotal[res.index()];
/*     */   }
/*     */   
/*     */   public double rate(TRADABLE res) {
/*  71 */     calc();
/*  72 */     return this.best[res.index()];
/*     */   }
/*     */   
/*     */   double rateTotal(Recipe res) {
/*  76 */     calc();
/*  77 */     return this.rateTot[res.index()];
/*     */   }
/*     */   
/*     */   public Recipe bestRecipe(TRADABLE res) {
/*  81 */     calc();
/*  82 */     return this.bestR[res.index()];
/*     */   }
/*     */   
/*  85 */   RecipeRatesPlayer(Recipes recp) { this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  89 */           file.i(RecipeRatesPlayer.this.boData.size());
/*  90 */           for (RecipeRatesPlayer.Data d : RecipeRatesPlayer.this.boData) {
/*  91 */             file.d(d.prev);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  97 */           int am = file.i();
/*  98 */           for (int i = 0; i < am; i++)
/*  99 */             ((RecipeRatesPlayer.Data)RecipeRatesPlayer.this.boData.getC(i)).prev = file.d(); 
/* 100 */           RecipeRatesPlayer.this.tt = 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 105 */           for (RecipeRatesPlayer.Data d : RecipeRatesPlayer.this.boData) {
/* 106 */             d.prev = -1.0D;
/* 107 */             d.am = 0;
/* 108 */             d.mul = 0.0D;
/*     */           } 
/* 110 */           RecipeRatesPlayer.this.tt = 0; } }; this.rateTot = new double[recp.all().size()]; this.recp = recp; for (Industry ins : (SETT.ROOMS()).industries.all) { if (ins.bonus() != null) {
/*     */         this.mapBo.put(ins.bonus().index(), this.boData.size()); this.boData.add(new Data());
/*     */       }  if (ins.conBonus != null) {
/*     */         this.mapBo.put(ins.conBonus.index(), this.boData.size()); this.boData.add(new Data());
/*     */       }  }
/* 115 */      } private void calc() { if (this.rateI == GAME.updateI())
/*     */       return; 
/* 117 */     this.rateI = GAME.updateI();
/*     */ 
/*     */     
/* 120 */     ENTITY[] ee = SETT.ENTITIES().getAllEnts();
/*     */     
/* 122 */     for (int j = 0; j < 256; j++) {
/* 123 */       if (this.tt >= ee.length) {
/* 124 */         for (Data d : this.boData) {
/* 125 */           d.calc();
/*     */         }
/*     */         
/* 128 */         this.tt = 0;
/*     */       } else {
/* 130 */         ENTITY e = ee[this.tt++];
/* 131 */         if (e instanceof Humanoid) {
/* 132 */           Humanoid a = (Humanoid)e;
/* 133 */           RoomInstance ww = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/* 134 */           if (ww != null && ww instanceof ROOM_PRODUCER_INSTANCE) {
/* 135 */             Industry ii = ((ROOM_PRODUCER_INSTANCE)ww).industry();
/* 136 */             if (ii.bonus() != null) {
/* 137 */               ((Data)this.boData.get(this.mapBo.get(ii.bonus().index()))).add(a, ww, ii);
/*     */             }
/*     */             
/* 140 */             if (ii.conBonus != null) {
/* 141 */               ((Data)this.boData.get(this.mapBo.get(ii.conBonus.index()))).add(a, ww, ii);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     Arrays.fill(this.best, Double.MAX_VALUE);
/* 155 */     Arrays.fill(this.bestTotal, Double.MAX_VALUE);
/*     */     
/* 157 */     for (int iii = 0; iii < this.recp.all().size(); iii++) {
/* 158 */       Recipe ii = (Recipe)this.recp.all().get(iii);
/* 159 */       double r = 1.0D / ii.rate * boost(ii);
/* 160 */       if (r < this.best[ii.out.index()]) {
/* 161 */         this.best[ii.out.index()] = r;
/*     */       }
/*     */     } 
/* 164 */     for (int i = 0; i < 10; i++) {
/* 165 */       for (int k = 0; k < this.recp.all().size(); k++) {
/* 166 */         Recipe ii = (Recipe)this.recp.all().get(k);
/* 167 */         set2(ii);
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void set2(Recipe ii) {
/* 175 */     double mm = 1.0D / ii.rate * boost(ii);
/*     */     
/* 177 */     if (this.bestR[ii.out.index()] == null)
/* 178 */       this.bestR[ii.out.index()] = ii;  byte b; int i;
/*     */     RecipeInput[] arrayOfRecipeInput;
/* 180 */     for (i = (arrayOfRecipeInput = ii.ins).length, b = 0; b < i; ) { RecipeInput recipeInput = arrayOfRecipeInput[b];
/* 181 */       if (this.bestTotal[recipeInput.res.index()] == Double.MAX_VALUE)
/*     */         return; 
/* 183 */       mm += recipeInput.rate * this.bestTotal[recipeInput.res.index()] / ii.rate * boost(recipeInput);
/*     */       b++; }
/*     */     
/* 186 */     this.rateTot[ii.index] = mm;
/*     */ 
/*     */ 
/*     */     
/* 190 */     if (mm < this.bestTotal[ii.out.index()]) {
/* 191 */       this.bestTotal[ii.out.index()] = mm;
/* 192 */       this.bestR[ii.out.index()] = ii;
/*     */     } 
/*     */   }
/*     */   
/*     */   private double boost(Recipe bo) {
/* 197 */     return boost(bo.bo);
/*     */   }
/*     */   
/*     */   private double boost(RecipeInput bo) {
/* 201 */     if (bo.boost != null)
/* 202 */       return boost(bo.boost); 
/* 203 */     return 1.0D;
/*     */   }
/*     */   
/*     */   public double boost(Boostable bo) {
/* 207 */     calc();
/* 208 */     if (this.mapBo.contains(bo.index())) {
/* 209 */       return ((Data)this.boData.get(this.mapBo.get(bo.index()))).get(bo);
/*     */     }
/* 211 */     return bo.get((BOOSTABLE_O)HCLASS_RACE.clP());
/*     */   }
/*     */   
/*     */   private static class Data {
/*     */     double prev;
/*     */     double mul;
/*     */     int am;
/*     */     
/*     */     private Data() {
/* 220 */       this.prev = -1.0D;
/* 221 */       this.mul = 1.0D;
/* 222 */       this.am = 1;
/*     */     }
/*     */     
/*     */     void add(Humanoid h, RoomInstance work, Industry i) {
/* 226 */       this.am++;
/* 227 */       double mul = 1.0D;
/* 228 */       if (!(work.blueprintI() instanceof settlement.room.food.pasture.ROOM_PASTURE))
/*     */       {
/*     */         
/* 231 */         mul *= IndustryUtil.roomBonus(work, (IndustryRate)i); } 
/* 232 */       mul *= work.employees().totEfficiency();
/* 233 */       mul *= i.bonus().get((BOOSTABLE_O)h.indu());
/* 234 */       this.mul += mul;
/*     */     }
/*     */ 
/*     */     
/*     */     void addD(Humanoid h, RoomInstance work, Industry i) {
/* 239 */       this.am++;
/* 240 */       double mul = 1.0D;
/* 241 */       LOG.ln((work.blueprint()).key);
/* 242 */       mul *= IndustryUtil.roomBonus(work, (IndustryRate)i);
/* 243 */       LOG.ln(Double.valueOf(mul));
/* 244 */       mul *= work.employees().totEfficiency();
/* 245 */       LOG.ln(Double.valueOf(mul));
/* 246 */       mul *= i.bonus().get((BOOSTABLE_O)h.indu());
/* 247 */       LOG.ln(Double.valueOf(mul));
/* 248 */       this.mul += mul;
/*     */     }
/*     */     
/*     */     public double get(Boostable bo) {
/* 252 */       if (this.prev < 0.0D)
/* 253 */         return bo.get((BOOSTABLE_O)HCLASS_RACE.clP()); 
/* 254 */       return this.prev;
/*     */     }
/*     */     
/*     */     void calc() {
/* 258 */       if (this.am > 0) {
/* 259 */         this.prev = this.mul / this.am;
/*     */       } else {
/* 261 */         this.prev = -1.0D;
/* 262 */       }  this.mul = 0.0D;
/* 263 */       this.am = 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\RecipeRatesPlayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */