/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
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
/*     */ 
/*     */ 
/*     */ public class AgeType
/*     */ {
/*     */   public final CharSequence name;
/*     */   public final SPRITE icon;
/*     */   private final RMapInt<HCLASS_RACE> limit;
/*     */   private final int typeI;
/*     */   public final Boostable limitMax;
/*     */   
/*     */   AgeType(SPRITE icon, CharSequence name, StatsInit init, int allI) {
/* 118 */     this.name = name;
/* 119 */     this.icon = icon;
/* 120 */     this.limit = new RMapInt(HCLASS_RACE.MAP(), 0, 100, 16);
/* 121 */     this.typeI = allI;
/* 122 */     init.savers.put("EDU_AGE_TYPE" + allI, this.limit);
/* 123 */     this.limitMax = BOOSTING.push("EDUCATION_LIMIT_" + allI, 10.0D, String.valueOf(StatsEducation.¤¤limit) + ": " + String.valueOf(StatsEducation.¤¤limit), StatsEducation.¤¤limitD, icon, (BoostableCat)BOOSTABLES.CIVICS());
/*     */   }
/*     */   
/*     */   public int limit(HCLASS_RACE cl) {
/* 127 */     if (cl.race == null) {
/* 128 */       int l = 0;
/* 129 */       for (int ri = 0; ri < RACES.all().size(); ri++)
/* 130 */         l = Math.max(l, limit(HCLASS_RACE.clP((Race)RACES.all().get(ri), cl.cl))); 
/* 131 */       return l;
/*     */     } 
/*     */     
/* 134 */     return CLAMP.i(this.limit.get((MAPPED)cl), 0, limitMax(cl));
/*     */   }
/*     */   
/*     */   public int limit(HCLASS cl, Race r) {
/* 138 */     return limit(HCLASS_RACE.clP(r, cl));
/*     */   }
/*     */   
/*     */   public int limitMax(HCLASS_RACE cl) {
/* 142 */     return (int)Math.round(this.limitMax.get((BOOSTABLE_O)cl));
/*     */   }
/*     */   
/*     */   public int limitMax(HCLASS cl, Race r) {
/* 146 */     return limitMax(HCLASS_RACE.clP(r, cl));
/*     */   }
/*     */   
/*     */   public void limitSet(HCLASS_RACE cl, int l) {
/* 150 */     if (cl.race == null) {
/* 151 */       for (int ri = 0; ri < RACES.all().size(); ri++)
/* 152 */         limitSet(HCLASS_RACE.clP((Race)RACES.all().get(ri), cl.cl), l); 
/*     */       return;
/*     */     } 
/* 155 */     l = CLAMP.i(l, 0, limitMax(cl));
/* 156 */     this.limit.set((MAPPED)cl, l);
/*     */   }
/*     */   
/*     */   public void limitSet(HCLASS cl, Race r, int l) {
/* 160 */     limitSet(HCLASS_RACE.clP(r, cl), l);
/*     */   }
/*     */   
/*     */   public double limitSpeed(HCLASS_RACE cl) {
/* 164 */     return limitSpeed(cl.cl, cl.race);
/*     */   }
/*     */   
/*     */   public double limitSpeed(HCLASS cl, Race r) {
/* 168 */     double s = 1.0D;
/* 169 */     double e = 1.0D - 0.9D * limit(HCLASS_RACE.clP(r, cl)) / 100.0D;
/* 170 */     return (s + e) / 2.0D;
/*     */   }
/*     */   
/*     */   public double currentSpeed(Induvidual i) {
/* 174 */     return 1.0D - 0.9D * (StatsEducation.this.policy(i.popCL())).allT[this.typeI].indu().get(i) / 100.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void educate(Induvidual i, double amount) {
/* 179 */     StatsEducation.StatEducation s = StatsEducation.this.policy(i.clas(), i.race());
/* 180 */     s.educate(i, amount, s.allT[this.typeI]);
/*     */   }
/*     */   
/*     */   public boolean educateCan(Induvidual i) {
/* 184 */     int lim = limit(i.popCL());
/* 185 */     StatsEducation.StatEducation s = StatsEducation.this.policy(i.clas(), i.race());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     if (lim > s.allT[this.typeI].indu().get(i)) {
/* 191 */       return true;
/*     */     }
/* 193 */     if (lim > 0) {
/* 194 */       for (StatsEducation.StatEducation o : StatsEducation.this.all) {
/*     */         
/* 196 */         if (o == s)
/*     */           continue;  byte b; int j;
/*     */         STAT[] arrayOfSTAT;
/* 199 */         for (j = (arrayOfSTAT = o.allT).length, b = 0; b < j; ) { STAT ss = arrayOfSTAT[b];
/* 200 */           if (ss.indu().get(i) > 0)
/*     */           {
/* 202 */             return true;
/*     */           }
/*     */           b++; }
/*     */       
/*     */       } 
/*     */     }
/* 208 */     return false;
/*     */   }
/*     */   
/*     */   public void hoverLimit(GUI_BOX text, HCLASS_RACE cl) {
/* 212 */     GBox b = (GBox)text;
/*     */     
/* 214 */     text.title((CharSequence)Str.TMP.clear().add(StatsEducation.¤¤limit).add(':').s().add(this.name));
/* 215 */     b.text(StatsEducation.¤¤limitD);
/*     */     
/* 217 */     b.NL(4);
/* 218 */     b.textL(StatsEducation.¤¤currentLimit);
/* 219 */     b.tab(6);
/* 220 */     b.add((SPRITE)GFORMAT.perc(b.text(), limit(cl) / 100.0D));
/* 221 */     b.NL();
/* 222 */     b.textL(StatsEducation.¤¤currentLimitSpeed);
/* 223 */     b.tab(6);
/* 224 */     b.add((SPRITE)GFORMAT.f1(b.text(), limitSpeed(cl), 2.0D));
/* 225 */     b.NL();
/* 226 */     b.textL(StatsEducation.¤¤LimitMax);
/* 227 */     b.tab(6);
/* 228 */     b.add((SPRITE)GFORMAT.percGood(b.text(), limitMax(cl) / 100.0D));
/* 229 */     b.NL();
/* 230 */     this.limitMax.hover((GUI_BOX)b, (BOOSTABLE_O)cl, true);
/* 231 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsEducation$AgeType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */