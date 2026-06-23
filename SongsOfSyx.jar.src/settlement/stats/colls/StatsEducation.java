/*     */ package settlement.stats.colls;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class StatsEducation extends StatCollection {
/*  33 */   private static CharSequence ¤¤childHood = "¤Childhood"; public static final int LIMIT_MAX = 100;
/*  34 */   private static CharSequence ¤¤adultHood = "¤Adulthood";
/*     */   
/*  36 */   private static CharSequence ¤¤currentPolicy = "¤Current Policy";
/*  37 */   private static CharSequence ¤¤currentLimit = "¤Current Limit";
/*  38 */   private static CharSequence ¤¤currentLimitSpeed = "¤Limit Speed";
/*  39 */   private static CharSequence ¤¤LimitMax = "¤Max Limit";
/*     */   
/*  41 */   private static CharSequence ¤¤name = "Enlightenment";
/*  42 */   private static CharSequence ¤¤desc = "Stats regarding your education levels, and boosts surrounding it.";
/*  43 */   private static CharSequence ¤¤limit = "¤Study Limit";
/*  44 */   private static CharSequence ¤¤limitD = "The maximum enlightenment allowed. High enlightenment gives diminishing returns, meaning a high limit will take longer to achieve.";
/*     */   public final LIST<StatEducation> all;
/*     */   
/*     */   static {
/*  48 */     D.ts(StatsEducation.class);
/*     */   }
/*     */ 
/*     */   
/*  52 */   private final RMapInt<HCLASS_RACE> policy = new RMapInt(HCLASS_RACE.MAP(), 0, 100);
/*     */   
/*     */   public final AgeType child;
/*     */   
/*     */   public final AgeType adult;
/*     */   
/*     */   public final LIST<AgeType> allAges;
/*     */ 
/*     */   
/*     */   public StatsEducation(StatsInit init) {
/*  62 */     super(init, "EDUCATION", ¤¤name, ¤¤desc);
/*     */     
/*  64 */     this.child = new AgeType((SPRITE)(UI.icons()).s.reproduction, ¤¤childHood, init, 0);
/*  65 */     this.adult = new AgeType((SPRITE)(UI.icons()).s.human, ¤¤adultHood, init, 1);
/*  66 */     this.allAges = (LIST<AgeType>)new ArrayList((Object[])new AgeType[] { this.child, this.adult });
/*  67 */     this.all = (LIST<StatEducation>)new ArrayList((Object[])new StatEducation[] {
/*  68 */           new StatEducation("EDUCATION", init, (UI.icons()).l.book.small, 0), 
/*  69 */           new StatEducation("INDOCTRINATION", init, (UI.icons()).l.work.small, 1)
/*     */         });
/*     */     
/*  72 */     init.savers.put("EDUCATION_POL", this.policy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatEducation policy(HCLASS_RACE cl) {
/*  79 */     return policy(cl.cl, cl.race);
/*     */   }
/*     */   
/*     */   public StatEducation policy(HCLASS cl, Race r) {
/*  83 */     if (r == null) {
/*  84 */       StatEducation rr = policy(cl, (Race)RACES.all().get(0));
/*  85 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  86 */         if (policy(cl, (Race)RACES.all().get(ri)) != rr)
/*  87 */           return null; 
/*     */       } 
/*  89 */       return rr;
/*     */     } 
/*  91 */     return (StatEducation)this.all.get(this.policy.get((MAPPED)HCLASS_RACE.clP(r, cl)));
/*     */   }
/*     */   
/*     */   public void policySet(HCLASS cl, Race r, StatEducation e) {
/*  95 */     if (r == null) {
/*  96 */       for (int ri = 0; ri < RACES.all().size(); ri++)
/*  97 */         policySet(cl, (Race)RACES.all().get(ri), e); 
/*     */       return;
/*     */     } 
/* 100 */     this.policy.set((MAPPED)HCLASS_RACE.clP(r, cl), e.index);
/*     */   }
/*     */   
/*     */   public void policySet(HCLASS_RACE cl, StatEducation e) {
/* 104 */     policySet(cl.cl, cl.race, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public class AgeType
/*     */   {
/*     */     public final CharSequence name;
/*     */     
/*     */     public final SPRITE icon;
/*     */     private final RMapInt<HCLASS_RACE> limit;
/*     */     private final int typeI;
/*     */     public final Boostable limitMax;
/*     */     
/*     */     AgeType(SPRITE icon, CharSequence name, StatsInit init, int allI) {
/* 118 */       this.name = name;
/* 119 */       this.icon = icon;
/* 120 */       this.limit = new RMapInt(HCLASS_RACE.MAP(), 0, 100, 16);
/* 121 */       this.typeI = allI;
/* 122 */       init.savers.put("EDU_AGE_TYPE" + allI, this.limit);
/* 123 */       this.limitMax = BOOSTING.push("EDUCATION_LIMIT_" + allI, 10.0D, String.valueOf(StatsEducation.¤¤limit) + ": " + String.valueOf(StatsEducation.¤¤limit), StatsEducation.¤¤limitD, icon, (BoostableCat)BOOSTABLES.CIVICS());
/*     */     }
/*     */     
/*     */     public int limit(HCLASS_RACE cl) {
/* 127 */       if (cl.race == null) {
/* 128 */         int l = 0;
/* 129 */         for (int ri = 0; ri < RACES.all().size(); ri++)
/* 130 */           l = Math.max(l, limit(HCLASS_RACE.clP((Race)RACES.all().get(ri), cl.cl))); 
/* 131 */         return l;
/*     */       } 
/*     */       
/* 134 */       return CLAMP.i(this.limit.get((MAPPED)cl), 0, limitMax(cl));
/*     */     }
/*     */     
/*     */     public int limit(HCLASS cl, Race r) {
/* 138 */       return limit(HCLASS_RACE.clP(r, cl));
/*     */     }
/*     */     
/*     */     public int limitMax(HCLASS_RACE cl) {
/* 142 */       return (int)Math.round(this.limitMax.get((BOOSTABLE_O)cl));
/*     */     }
/*     */     
/*     */     public int limitMax(HCLASS cl, Race r) {
/* 146 */       return limitMax(HCLASS_RACE.clP(r, cl));
/*     */     }
/*     */     
/*     */     public void limitSet(HCLASS_RACE cl, int l) {
/* 150 */       if (cl.race == null) {
/* 151 */         for (int ri = 0; ri < RACES.all().size(); ri++)
/* 152 */           limitSet(HCLASS_RACE.clP((Race)RACES.all().get(ri), cl.cl), l); 
/*     */         return;
/*     */       } 
/* 155 */       l = CLAMP.i(l, 0, limitMax(cl));
/* 156 */       this.limit.set((MAPPED)cl, l);
/*     */     }
/*     */     
/*     */     public void limitSet(HCLASS cl, Race r, int l) {
/* 160 */       limitSet(HCLASS_RACE.clP(r, cl), l);
/*     */     }
/*     */     
/*     */     public double limitSpeed(HCLASS_RACE cl) {
/* 164 */       return limitSpeed(cl.cl, cl.race);
/*     */     }
/*     */     
/*     */     public double limitSpeed(HCLASS cl, Race r) {
/* 168 */       double s = 1.0D;
/* 169 */       double e = 1.0D - 0.9D * limit(HCLASS_RACE.clP(r, cl)) / 100.0D;
/* 170 */       return (s + e) / 2.0D;
/*     */     }
/*     */     
/*     */     public double currentSpeed(Induvidual i) {
/* 174 */       return 1.0D - 0.9D * (StatsEducation.this.policy(i.popCL())).allT[this.typeI].indu().get(i) / 100.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void educate(Induvidual i, double amount) {
/* 179 */       StatsEducation.StatEducation s = StatsEducation.this.policy(i.clas(), i.race());
/* 180 */       s.educate(i, amount, s.allT[this.typeI]);
/*     */     }
/*     */     
/*     */     public boolean educateCan(Induvidual i) {
/* 184 */       int lim = limit(i.popCL());
/* 185 */       StatsEducation.StatEducation s = StatsEducation.this.policy(i.clas(), i.race());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 190 */       if (lim > s.allT[this.typeI].indu().get(i)) {
/* 191 */         return true;
/*     */       }
/* 193 */       if (lim > 0) {
/* 194 */         for (StatsEducation.StatEducation o : StatsEducation.this.all) {
/*     */           
/* 196 */           if (o == s)
/*     */             continue;  byte b; int j;
/*     */           STAT[] arrayOfSTAT;
/* 199 */           for (j = (arrayOfSTAT = o.allT).length, b = 0; b < j; ) { STAT ss = arrayOfSTAT[b];
/* 200 */             if (ss.indu().get(i) > 0)
/*     */             {
/* 202 */               return true;
/*     */             }
/*     */             b++; }
/*     */         
/*     */         } 
/*     */       }
/* 208 */       return false;
/*     */     }
/*     */     
/*     */     public void hoverLimit(GUI_BOX text, HCLASS_RACE cl) {
/* 212 */       GBox b = (GBox)text;
/*     */       
/* 214 */       text.title((CharSequence)Str.TMP.clear().add(StatsEducation.¤¤limit).add(':').s().add(this.name));
/* 215 */       b.text(StatsEducation.¤¤limitD);
/*     */       
/* 217 */       b.NL(4);
/* 218 */       b.textL(StatsEducation.¤¤currentLimit);
/* 219 */       b.tab(6);
/* 220 */       b.add((SPRITE)GFORMAT.perc(b.text(), limit(cl) / 100.0D));
/* 221 */       b.NL();
/* 222 */       b.textL(StatsEducation.¤¤currentLimitSpeed);
/* 223 */       b.tab(6);
/* 224 */       b.add((SPRITE)GFORMAT.f1(b.text(), limitSpeed(cl), 2.0D));
/* 225 */       b.NL();
/* 226 */       b.textL(StatsEducation.¤¤LimitMax);
/* 227 */       b.tab(6);
/* 228 */       b.add((SPRITE)GFORMAT.percGood(b.text(), limitMax(cl) / 100.0D));
/* 229 */       b.NL();
/* 230 */       this.limitMax.hover((GUI_BOX)b, (BOOSTABLE_O)cl, true);
/* 231 */       b.NL();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final class StatEducation
/*     */   {
/* 239 */     private double dAmount = 0.0D;
/*     */     
/*     */     private final STAT[] allT;
/*     */     private final int index;
/*     */     public STAT total;
/*     */     
/*     */     StatEducation(String key, StatsInit init, SPRITE icon, int index) {
/* 246 */       this.allT = new STAT[StatsEducation.this.allAges.size()];
/* 247 */       for (int i = 0; i < this.allT.length; i++) {
/* 248 */         this.allT[i] = (STAT)new STATData(null, key + "DC" + key, init, (INT_O.INT_OE)new DataO.DataByte(init.count, key + "DC" + key, 100));
/* 249 */         init.copier.add(this.allT[i].indu());
/*     */       } 
/*     */       
/* 252 */       this.index = index;
/* 253 */       this.total = (STAT)new STATFake(key, init)
/*     */         {
/*     */           protected double getDD(HCLASS s, Race r, int daysBack)
/*     */           {
/* 257 */             double res = 0.0D; byte b; int i; STAT[] arrayOfSTAT;
/* 258 */             for (i = (arrayOfSTAT = StatsEducation.StatEducation.this.allT).length, b = 0; b < i; ) { STAT t = arrayOfSTAT[b];
/* 259 */               res += t.data(s).getD(r, daysBack); b++; }
/*     */             
/* 261 */             return res / StatsEducation.StatEducation.this.allT.length;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 267 */             GBox b = (GBox)text;
/*     */ 
/*     */             
/* 270 */             for (StatsEducation.AgeType t : (StatsEducation.StatEducation.access$0(StatsEducation.StatEducation.this)).allAges) {
/* 271 */               b.textLL(t.name);
/* 272 */               b.tab(6);
/* 273 */               b.add((SPRITE)GFORMAT.perc(b.text(), StatsEducation.StatEducation.this.allT[t.typeI].data(cl).getD(type)));
/* 274 */               b.NL();
/* 275 */               b.textL(StatsEducation.¤¤currentLimit);
/* 276 */               b.tab(6);
/* 277 */               b.add((SPRITE)GFORMAT.perc(b.text(), t.limit(cl, type) / 100.0D));
/* 278 */               b.NL();
/* 279 */               b.textL(StatsEducation.¤¤currentLimitSpeed);
/* 280 */               b.tab(6);
/* 281 */               b.add((SPRITE)GFORMAT.f1(b.text(), t.limitSpeed(cl, type) / 100.0D, 2.0D));
/* 282 */               b.sep();
/*     */             } 
/*     */             
/* 285 */             b.textLL(Dic.¤¤Total);
/* 286 */             b.tab(6);
/* 287 */             b.add((SPRITE)GFORMAT.perc(b.text(), getDD(cl, type, 0)));
/* 288 */             b.sep();
/* 289 */             super.hover(text, cl, type);
/*     */           }
/*     */ 
/*     */           
/*     */           protected double induGet(Induvidual i) {
/* 294 */             double res = 0.0D; byte b; int j;
/*     */             STAT[] arrayOfSTAT;
/* 296 */             for (j = (arrayOfSTAT = StatsEducation.StatEducation.this.allT).length, b = 0; b < j; ) { STAT t = arrayOfSTAT[b];
/*     */               
/* 298 */               res += t.indu().getD(i);
/*     */               b++; }
/*     */             
/* 301 */             return res / StatsEducation.StatEducation.this.allT.length;
/*     */           }
/*     */ 
/*     */           
/*     */           public void hover(GUI_BOX text, Induvidual indu) {
/* 306 */             GBox b = (GBox)text;
/* 307 */             b.textLL(StatsEducation.¤¤currentPolicy);
/* 308 */             b.tab(6);
/* 309 */             b.add((SPRITE)b.text().add(((StatsEducation.StatEducation.access$0(StatsEducation.StatEducation.this).policy(indu.clas(), indu.race())).total.info()).name));
/* 310 */             b.NL();
/*     */             
/* 312 */             for (StatsEducation.AgeType t : (StatsEducation.StatEducation.access$0(StatsEducation.StatEducation.this)).allAges) {
/* 313 */               b.textLL(t.name);
/* 314 */               b.tab(6);
/* 315 */               b.add((SPRITE)GFORMAT.perc(b.text(), StatsEducation.StatEducation.this.allT[t.typeI].indu().getD(indu)));
/* 316 */               b.NL();
/*     */             } 
/*     */             
/* 319 */             super.hover(text, indu);
/*     */           }
/*     */         };
/* 322 */       (this.total.info()).icon = icon;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void educate(Induvidual i, double amount, STAT toIncrease) {
/* 328 */       double dam = amount + this.dAmount;
/*     */       
/* 330 */       int am = (int)dam;
/* 331 */       this.dAmount = dam - am;
/* 332 */       if (am == 0) {
/*     */         return;
/*     */       }
/* 335 */       am = decrease(i, am);
/*     */       
/* 337 */       if (am == 0) {
/*     */         return;
/*     */       }
/* 340 */       int max = toIncrease.indu().max(i) - toIncrease.indu().get(i);
/* 341 */       if (am > max) {
/* 342 */         this.dAmount += (am - max);
/* 343 */         am = max;
/*     */       } 
/* 345 */       toIncrease.indu().inc(i, am);
/*     */     }
/*     */     
/*     */     private int decrease(Induvidual i, int am) {
/* 349 */       if (am == 0) {
/* 350 */         return am;
/*     */       }
/* 352 */       for (StatEducation o : StatsEducation.this.all) {
/* 353 */         if (o == this)
/*     */           continue;  byte b; int j;
/*     */         STAT[] arrayOfSTAT;
/* 356 */         for (j = (arrayOfSTAT = o.allT).length, b = 0; b < j; ) { STAT os = arrayOfSTAT[b];
/* 357 */           int a = os.indu().get(i);
/* 358 */           if (am > a) {
/* 359 */             os.indu().inc(i, -a);
/* 360 */             am -= a;
/*     */           } else {
/* 362 */             os.indu().inc(i, -am);
/* 363 */             return 0;
/*     */           } 
/* 365 */           if (am <= 0)
/* 366 */             return 0; 
/*     */           b++; }
/*     */       
/*     */       } 
/* 370 */       return am;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsEducation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */