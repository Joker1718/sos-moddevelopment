/*     */ package init.race.bio;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBurial;
/*     */ import settlement.stats.service.StatServiceImp;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tree;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ final class BioOpinion
/*     */ {
/*     */   private final BioOpinionData datas;
/*  21 */   private final ArrayList<ArrayList<Prio>> prios = new ArrayList(HCLASSES.ALL().size());
/*  22 */   private final ArrayList<Prio> tmp = new ArrayList(STATS.all().size());
/*  23 */   private final double[] tres = new double[] { 0.25D, 0.5D, 0.95D };
/*     */ 
/*     */   
/*     */   BioOpinion(BioOpinionData normal, Race race) {
/*  27 */     this.datas = normal;
/*     */     
/*  29 */     for (HCLASS cl : HCLASSES.ALL()) {
/*     */       StatsBurial.StatGrave statGrave;
/*     */       
/*  32 */       Race r = race;
/*  33 */       Tree<Prio> sort = new Tree<Prio>(STATS.all().size())
/*     */         {
/*     */           protected boolean isGreaterThan(BioOpinion.Prio current, BioOpinion.Prio cmp)
/*     */           {
/*  37 */             return (current.prio > cmp.prio);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/*  42 */       boolean[] has = new boolean[STATS.all().size()];
/*     */       
/*  44 */       double m = 0.0D;
/*  45 */       STAT ss = null;
/*  46 */       for (StatServiceImp s : (STATS.SERVICE()).ALL) {
/*     */         
/*  48 */         has[s.total().index()] = true;
/*  49 */         if (s.total().standing().def(cl, r) > m) {
/*  50 */           ss = s.total();
/*  51 */           m = s.total().standing().def(cl, r);
/*     */         } 
/*  53 */         if (ss != null) {
/*  54 */           double pri = (ss.standing().definition(r)).prio * (ss.standing().definition(r).get(cl)).max;
/*  55 */           if (pri > 0.0D) {
/*  56 */             sort.add(new Prio(ss, pri));
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  62 */       m = 0.0D;
/*  63 */       ss = null;
/*  64 */       for (StatsBurial.StatGrave s : STATS.BURIAL().graves()) {
/*  65 */         has[s.index()] = true;
/*  66 */         if (s.standing().def(cl, r) > m) {
/*  67 */           statGrave = s;
/*  68 */           m = s.standing().def(cl, r);
/*     */         } 
/*     */       } 
/*  71 */       if (statGrave != null) {
/*  72 */         double pri = (statGrave.standing().definition(r)).prio * (statGrave.standing().definition(r).get(cl)).max;
/*  73 */         if (pri > 0.0D) {
/*  74 */           sort.add(new Prio((STAT)statGrave, pri));
/*     */         }
/*     */       } 
/*     */       
/*  78 */       for (STAT s : STATS.all()) {
/*  79 */         if (has[s.index()])
/*     */           continue; 
/*  81 */         if (s.standing() != null) {
/*  82 */           double pri = (s.standing().definition(r)).prio * (s.standing().definition(r).get(cl)).max;
/*  83 */           if (pri > 0.0D) {
/*  84 */             sort.add(new Prio(s, pri));
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*  89 */       ArrayList<Prio> pris = new ArrayList(sort.size());
/*     */ 
/*     */ 
/*     */       
/*  93 */       while (sort.hasMore())
/*     */       {
/*  95 */         pris.add(sort.pollGreatest());
/*     */       }
/*  97 */       this.prios.add(pris);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private BioOpinionData get(Induvidual indu) {
/* 103 */     return this.datas;
/*     */   }
/*     */   
/*     */   private BioOpinionData get(HCLASS cl, Race race) {
/* 107 */     return this.datas;
/*     */   }
/*     */   
/*     */   public CharSequence title(Humanoid indu, double value) {
/* 111 */     return get(indu.indu()).title(indu, value);
/*     */   }
/*     */   
/*     */   public void get(LIST<Str> res, Humanoid a, long ran) {
/* 115 */     for (Str s : res)
/* 116 */       s.clear(); 
/* 117 */     HCLASS cl = a.indu().clas();
/* 118 */     Race race = a.race();
/* 119 */     BioOpinionData data = get(cl, race);
/*     */     
/* 121 */     int index = 0;
/* 122 */     if ((ran & 0x1FL) == 0L) {
/* 123 */       ((Str)res.get(index++)).add(data.funny(ran));
/*     */     }
/* 125 */     ArrayList<Prio> pp = (ArrayList<Prio>)this.prios.get(cl.index());
/*     */ 
/*     */     
/* 128 */     this.tmp.clearSloppy();
/* 129 */     long r = ran;
/* 130 */     for (Prio p : pp) {
/* 131 */       if ((r & 0x1L) == 1L) {
/* 132 */         this.tmp.add(p);
/*     */       }
/* 134 */       r >>= 1L;
/*     */     } 
/*     */     
/*     */     byte b;
/*     */     int i;
/*     */     double[] arrayOfDouble;
/* 140 */     for (i = (arrayOfDouble = this.tres).length, b = 0; b < i; ) { double t = arrayOfDouble[b];
/* 141 */       for (int j = 0; j < this.tmp.size(); j++) {
/* 142 */         Prio p = (Prio)this.tmp.get(j);
/* 143 */         double v = value(p, cl, race, p.stat.data(cl).getD(race));
/* 144 */         if (v < t) {
/* 145 */           ((Str)res.get(index++)).add(data.get(p.stat, a, ran));
/* 146 */           this.tmp.removeOrdered(j);
/* 147 */           j--;
/* 148 */           if (index >= res.size()) {
/*     */             return;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/* 155 */     this.tmp.clearSloppy();
/* 156 */     r = ran;
/* 157 */     for (Prio p : pp) {
/* 158 */       if ((r & 0x1L) == 0L) {
/* 159 */         this.tmp.add(p);
/*     */       }
/* 161 */       r >>= 1L;
/*     */     } 
/*     */ 
/*     */     
/* 165 */     for (i = (arrayOfDouble = this.tres).length, b = 0; b < i; ) { double t = arrayOfDouble[b];
/* 166 */       for (int j = 0; j < this.tmp.size(); j++) {
/* 167 */         Prio p = (Prio)this.tmp.get(j);
/* 168 */         double v = value(p, cl, race, p.stat.data(cl).getD(race));
/* 169 */         if (v < t) {
/* 170 */           ((Str)res.get(index++)).add(data.get(p.stat, a, ran));
/* 171 */           this.tmp.removeOrdered(j);
/* 172 */           j--;
/* 173 */           if (index >= res.size())
/*     */             return; 
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/* 179 */     if (res.size() == 0) {
/* 180 */       ((Str)res.get(index)).add(data.full(ran));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void get(LIST<Str> res, Humanoid h) {
/* 186 */     for (Str s : res) {
/* 187 */       s.clear();
/*     */     }
/* 189 */     Induvidual indu = h.indu();
/* 190 */     BioOpinionData data = get(indu);
/*     */     
/* 192 */     long ran = STATS.RAN().get(indu, 0);
/* 193 */     ran <<= 32L;
/* 194 */     ran |= STATS.RAN().get(indu, 36);
/*     */     
/* 196 */     int index = 0;
/* 197 */     if ((ran & 0x1FL) == 0L) {
/* 198 */       ((Str)res.get(index++)).add(data.funny(ran));
/*     */     }
/* 200 */     ArrayList<Prio> pp = (ArrayList<Prio>)this.prios.get(indu.clas().index());
/*     */ 
/*     */     
/* 203 */     this.tmp.clearSloppy();
/* 204 */     long r = ran;
/* 205 */     for (Prio p : pp) {
/* 206 */       if ((r & 0x1L) == 1L) {
/* 207 */         this.tmp.add(p);
/*     */       }
/* 209 */       r >>= 1L;
/*     */     }  byte b;
/*     */     int i;
/*     */     double[] arrayOfDouble;
/* 213 */     for (i = (arrayOfDouble = this.tres).length, b = 0; b < i; ) { double t = arrayOfDouble[b];
/* 214 */       for (int j = 0; j < this.tmp.size(); j++) {
/* 215 */         Prio p = (Prio)this.tmp.get(j);
/* 216 */         double v = value(p, indu.clas(), indu.race(), p.stat.indu().getD(indu));
/* 217 */         if (v < t) {
/* 218 */           ((Str)res.get(index++)).add(data.get(p.stat, h, ran));
/* 219 */           this.tmp.removeOrdered(j);
/* 220 */           j--;
/* 221 */           if (index >= res.size()) {
/*     */             return;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/* 228 */     this.tmp.clearSloppy();
/* 229 */     r = ran;
/* 230 */     for (Prio p : pp) {
/* 231 */       if ((r & 0x1L) == 0L) {
/* 232 */         this.tmp.add(p);
/*     */       }
/* 234 */       r >>= 1L;
/*     */     } 
/*     */ 
/*     */     
/* 238 */     for (i = (arrayOfDouble = this.tres).length, b = 0; b < i; ) { double t = arrayOfDouble[b];
/* 239 */       for (int j = 0; j < this.tmp.size(); j++) {
/* 240 */         Prio p = (Prio)this.tmp.get(j);
/* 241 */         double v = value(p, indu.clas(), indu.race(), p.stat.indu().getD(indu));
/* 242 */         if (v < t) {
/* 243 */           ((Str)res.get(index++)).add(data.get(p.stat, h, ran));
/* 244 */           this.tmp.removeOrdered(j);
/* 245 */           j--;
/* 246 */           if (index >= res.size())
/*     */             return; 
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/* 252 */     if (res.size() == 0) {
/* 253 */       ((Str)res.get(index)).add(data.full(ran));
/*     */     }
/*     */     
/* 256 */     for (Str s : res) {
/* 257 */       BioLine.insert.set(s, h);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private double value(Prio p, HCLASS cl, Race r, double v) {
/* 263 */     StatStanding.StandingDef.StandingData def = p.stat.standing().definition(r).get(cl);
/* 264 */     if (def.from > def.to)
/* 265 */       v = 1.0D - v; 
/* 266 */     return v;
/*     */   }
/*     */   
/*     */   private static final class Prio
/*     */   {
/*     */     private final STAT stat;
/*     */     private final float prio;
/*     */     
/*     */     Prio(STAT stat, double prio) {
/* 275 */       this.stat = stat;
/* 276 */       this.prio = (float)prio;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\bio\BioOpinion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */