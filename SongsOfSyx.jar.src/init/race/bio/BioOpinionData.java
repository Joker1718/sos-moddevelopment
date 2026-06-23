/*     */ package init.race.bio;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.muls.StatsMultipliers;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.util.StatsJson;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ final class BioOpinionData
/*     */ {
/*     */   private final CharSequence[] funnies;
/*     */   private final CharSequence[] full;
/*  20 */   private final Opinion[] all = new Opinion[STATS.all().size()];
/*  21 */   private final Str stmp = new Str(256);
/*     */   
/*     */   private final CharSequence[][] titles;
/*     */ 
/*     */   
/*     */   BioOpinionData(Json org, Json spe) throws IOException {
/*  27 */     this.titles = new CharSequence[][] {
/*  28 */         tt("HAPPY", org, spe), 
/*  29 */         tt("HAPPY_SOSO", org, spe), 
/*  30 */         tt("HAPPY_NO", org, spe)
/*     */       };
/*     */     
/*  33 */     Opinion def = new Opinion();
/*  34 */     for (int i = 0; i < this.all.length; i++) {
/*  35 */       if (this.all[i] == null)
/*  36 */         this.all[i] = def; 
/*  37 */     }  for (STAT s : STATS.all()) {
/*  38 */       this.all[s.index()] = (new Opinion()).setMore((s.info()).defOpinion.more).setLess((s.info()).defOpinion.less);
/*     */     }
/*     */ 
/*     */     
/*  42 */     this.funnies = tt("FUNNY", org, spe);
/*  43 */     this.full = tt("NOTHING", org, spe);
/*     */ 
/*     */     
/*  46 */     ArrayList<Json> js = new ArrayList(2);
/*  47 */     js.add(org);
/*  48 */     if (spe != null) {
/*  49 */       js.add(spe);
/*     */     }
/*  51 */     for (Json jj : js) {
/*  52 */       Json j = jj.json("STATS_MORE");
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
/*  68 */       j = jj.json("STATS_LESS");
/*     */     } 
/*     */   }
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
/*     */   private CharSequence[] tt(String key, Json org, Json spe) {
/*  86 */     if (spe != null && spe.has(key))
/*  87 */       return BioLine.insert.check((CharSequence[])spe.texts(key)); 
/*  88 */     return BioLine.insert.check((CharSequence[])org.textsTry(key));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence get(STAT s, Humanoid a, long ran) {
/*  94 */     if ((s.standing().definition(a.race()).get(a.indu().clas())).from > (s.standing().definition(a.race()).get(a.indu().clas())).to) {
/*  95 */       return less(s, ran, a);
/*     */     }
/*  97 */     return more(s, ran, a);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence title(Humanoid h, double value) {
/* 102 */     if (value > 0.95D)
/* 103 */       return get(h, this.titles[0], STATS.RAN().getL(h.indu(), 0)); 
/* 104 */     if (value > 0.8D)
/* 105 */       return get(h, this.titles[1], STATS.RAN().getL(h.indu(), 0)); 
/* 106 */     return get(h, this.titles[2], STATS.RAN().getL(h.indu(), 0));
/*     */   }
/*     */   
/*     */   public CharSequence funny(long ran) {
/* 110 */     return this.funnies[MATH.mod((int)ran, this.funnies.length)];
/*     */   }
/*     */   
/*     */   public CharSequence full(long ran) {
/* 114 */     return this.full[MATH.mod((int)ran, this.full.length)];
/*     */   }
/*     */   
/*     */   private CharSequence get(Humanoid i, CharSequence[] r, long ran) {
/* 118 */     if (r.length == 0)
/* 119 */       return Dic.empty; 
/* 120 */     this.stmp.clear().add(r[MATH.mod((int)ran, r.length)]);
/* 121 */     BioLine.insert.set(this.stmp, i);
/* 122 */     return (CharSequence)this.stmp;
/*     */   }
/*     */   
/*     */   private CharSequence more(STAT stat, long ran, Humanoid a) {
/* 126 */     Opinion i = this.all[stat.index()];
/* 127 */     if (i.more.length == 0)
/* 128 */       return Dic.empty; 
/* 129 */     CharSequence s = i.more[MATH.mod((int)ran, i.more.length)];
/* 130 */     this.stmp.clear().add(s);
/* 131 */     i.insert(this.stmp, stat, a);
/* 132 */     return (CharSequence)this.stmp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CharSequence less(STAT stat, long ran, Humanoid a) {
/* 139 */     Opinion i = this.all[stat.index()];
/* 140 */     if (i.less.length == 0)
/* 141 */       return Dic.empty; 
/* 142 */     CharSequence s = i.less[MATH.mod((int)ran, i.less.length)];
/* 143 */     this.stmp.clear().add(s);
/* 144 */     i.insert(this.stmp, stat, a);
/* 145 */     return (CharSequence)this.stmp;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\bio\BioOpinionData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */