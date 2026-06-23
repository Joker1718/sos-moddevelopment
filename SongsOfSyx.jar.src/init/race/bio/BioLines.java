/*     */ package init.race.bio;
/*     */ 
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import init.type.TRAIT;
/*     */ import init.type.TRAITS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ final class BioLines
/*     */ {
/*  19 */   final LinkedList<BioLine> descs = new LinkedList();
/*  20 */   final LinkedList<BioLine> houseP = new LinkedList();
/*     */   
/*     */   BioLines(BioLines org, Json json) {
/*  23 */     this(json);
/*     */     
/*  25 */     for (int i = 0; i < this.descs.size(); i++) {
/*  26 */       BioLine l = (BioLine)this.descs.get(i);
/*  27 */       if (!json.has(l.key)) {
/*  28 */         l.strings = ((BioLine)org.descs.get(i)).strings;
/*     */       }
/*     */     } 
/*  31 */     if (json.has("TRAIT")) {
/*  32 */       Json tj = json.json("TRAIT");
/*     */       
/*  34 */       for (TRAIT t : TRAITS.ALL()) {
/*  35 */         if (!tj.has(t.key())) {
/*  36 */           CharSequence[] dd1 = ((BioLine)this.descs.get(4 + t.index())).strings;
/*  37 */           CharSequence[] dd2 = ((BioLine)org.descs.get(4 + t.index())).strings;
/*     */           
/*  39 */           CharSequence[] dd = new CharSequence[dd1.length + dd2.length]; int j;
/*  40 */           for (j = 0; j < dd1.length; j++)
/*  41 */             dd[j] = dd1[j]; 
/*  42 */           for (j = 0; j < dd2.length; j++)
/*  43 */             dd[j + dd1.length] = dd2[j]; 
/*  44 */           ((BioLine)this.descs.get(4 + t.index())).strings = dd;
/*     */         } 
/*     */       } 
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
/*     */ 
/*     */   
/*     */   BioLines(Json json) {
/*  66 */     (new BioLine((LISTE<BioLine>)this.descs, json, "INFO_GENERAL3")).nlSet();
/*     */     
/*  68 */     this.houseP.add((new BioLine((LISTE)this.descs, json, "HOME_NONE_WORK")
/*     */         {
/*     */           protected boolean use(Humanoid a) {
/*  71 */             if (!a.indu().player())
/*  72 */               return false; 
/*  73 */             return ((STATS.HOME()).GETTER.hasSearched.indu().isMax(a.indu()) && !(STATS.HOME()).GETTER.has(a) && (STATS.WORK()).EMPLOYED.get(a) != null);
/*     */           }
/*  75 */         }).nlSet());
/*     */     
/*  77 */     this.houseP.add((new BioLine((LISTE)this.descs, json, "HOME_NONE")
/*     */         {
/*     */           protected boolean use(Humanoid a) {
/*  80 */             if (!a.indu().player())
/*  81 */               return false; 
/*  82 */             return ((STATS.HOME()).GETTER.hasSearched.indu().isMax(a.indu()) && !(STATS.HOME()).GETTER.has(a) && (STATS.WORK()).EMPLOYED.get(a) == null);
/*     */           }
/*  84 */         }).nlSet());
/*     */     
/*  86 */     this.houseP.add((new BioLine((LISTE)this.descs, json, "HOME_NONE_SEARCH")
/*     */         {
/*     */           protected boolean use(Humanoid a) {
/*  89 */             if (!a.indu().player())
/*  90 */               return false; 
/*  91 */             return (!(STATS.HOME()).GETTER.hasSearched.indu().isMax(a.indu()) && !(STATS.HOME()).GETTER.has(a));
/*     */           }
/*  93 */         }).nlSet());
/*     */ 
/*     */     
/*  96 */     Json tj = json.json("TRAIT");
/*     */     
/*  98 */     for (TRAIT t : TRAITS.ALL());
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
/* 111 */     (new Friend((LISTE)this.descs, json, "FRIEND")
/*     */       {
/*     */         protected boolean use(Humanoid a) {
/* 114 */           if (super.use(a)) {
/* 115 */             Humanoid b = (Humanoid)(STATS.POP()).FRIEND.get(a.indu());
/* 116 */             return (a.race().pref().race(b.indu().race()) >= 0.5D);
/*     */           } 
/* 118 */           return false;
/*     */         }
/* 120 */       }).nlSet();
/*     */     
/* 122 */     (new Friend((LISTE)this.descs, json, "FRIEND_ENEMY")
/*     */       {
/*     */         protected boolean use(Humanoid a) {
/* 125 */           if (super.use(a)) {
/* 126 */             Humanoid b = (Humanoid)(STATS.POP()).FRIEND.get(a.indu());
/* 127 */             return (a.race().pref().race(b.indu().race()) < 0.5D);
/*     */           } 
/* 129 */           return false;
/*     */         }
/* 131 */       }).nlSet();
/*     */     
/* 133 */     (new BioLine((LISTE)this.descs, json, "FRIEND_OTHER")
/*     */       {
/*     */         protected boolean use(Humanoid a) {
/* 136 */           if (!a.indu().player())
/* 137 */             return false; 
/* 138 */           return ((STATS.POP()).FRIEND.get(a.indu()) != null && (STATS.POP()).FRIEND.get(a.indu()) instanceof settlement.entity.animal.Animal);
/*     */         }
/* 140 */       }).nlSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     this.houseP.add((new BioLine((LISTE)this.descs, json, "HOME")
/*     */         {
/*     */           protected boolean use(Humanoid a) {
/* 152 */             if (a.indu().clas() == HCLASSES.NOBLE())
/* 153 */               return false; 
/* 154 */             HOME h = (STATS.HOME()).GETTER.get(a, this);
/* 155 */             if (h == null) {
/* 156 */               return false;
/*     */             }
/* 158 */             return (h.occupants() > 1);
/*     */           }
/* 160 */         }).nlSet());
/*     */     
/* 162 */     this.houseP.add((new BioLine((LISTE)this.descs, json, "HOME_ALONE")
/*     */         {
/*     */           protected boolean use(Humanoid a) {
/* 165 */             if (!a.indu().player())
/* 166 */               return false; 
/* 167 */             HOME h = (STATS.HOME()).GETTER.get(a, this);
/* 168 */             if (h == null)
/* 169 */               return false; 
/* 170 */             return (h.occupants() == 1);
/*     */           }
/* 172 */         }).nlSet());
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
/* 183 */     (new BioLine((LISTE)this.descs, json, "DIVISION")
/*     */       {
/*     */         protected boolean use(Humanoid a) {
/* 186 */           return (super.use(a) && (STATS.BATTLE()).DIV.get(a) != null);
/*     */         }
/* 188 */       }).nlSet();
/*     */     
/* 190 */     (new BioLine((LISTE)this.descs, json, "DIVISION_RECRUIT")
/*     */       {
/*     */         protected boolean use(Humanoid a) {
/* 193 */           return (super.use(a) && (STATS.BATTLE()).DIV.get(a) == null && (STATS.BATTLE()).RECRUIT.get(a) != null);
/*     */         }
/* 195 */       }).nlSet();
/*     */     
/* 197 */     (new BioLine((LISTE)this.descs, json, "DIVISION_NONE")
/*     */       {
/*     */         protected boolean use(Humanoid a) {
/* 200 */           return (super.use(a) && (STATS.BATTLE()).DIV.get(a) == null && (STATS.BATTLE()).RECRUIT.get(a) == null);
/*     */         }
/* 202 */       }).nlSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     (new BioLine((LISTE)this.descs, json, "WORK_EMPLOYED")
/*     */       {
/*     */         protected boolean use(Humanoid a) {
/* 214 */           return (super.use(a) && !(STATS.WORK()).WORK_TIME.indu().isMax(a.indu()) && a.indu().clas() != HCLASSES.NOBLE() && (STATS.WORK()).EMPLOYED.get(a) != null);
/*     */         }
/* 216 */       }).nlSet();
/*     */     
/* 218 */     (new BioLine((LISTE)this.descs, json, "WORK_UNEMPLOYED")
/*     */       {
/*     */         protected boolean use(Humanoid a) {
/* 221 */           return (super.use(a) && !(STATS.WORK()).WORK_TIME.indu().isMax(a.indu()) && a.indu().clas() != HCLASSES.NOBLE() && (STATS.WORK()).EMPLOYED.get(a) == null);
/*     */         }
/* 223 */       }).nlSet();
/*     */     
/* 225 */     (new BioLine((LISTE)this.descs, json, "WORK_LEISURE")
/*     */       {
/*     */         protected boolean use(Humanoid a) {
/* 228 */           return (super.use(a) && (STATS.WORK()).WORK_TIME.indu().isMax(a.indu()));
/*     */         }
/* 230 */       }).nlSet();
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
/*     */   private static class Origin
/*     */     extends BioLine
/*     */   {
/*     */     private final CAUSE_ARRIVE ca;
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
/*     */     Origin(LISTE<BioLine> all, Json json, String key, CAUSE_ARRIVE ca) {
/* 287 */       super(all, json, key);
/* 288 */       this.ca = ca;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean use(Humanoid a) {
/* 293 */       if (a.indu().clas() != HCLASSES.CITIZEN())
/* 294 */         return false; 
/* 295 */       if ((STATS.POP()).COUNT.arrive.get(a.indu()) != this.ca)
/* 296 */         return false; 
/* 297 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Friend
/*     */     extends BioLine
/*     */   {
/*     */     Friend(LISTE<BioLine> all, Json json, String key) {
/* 306 */       super(all, json, key);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean use(Humanoid a) {
/* 311 */       return (super.use(a) && (STATS.POP()).FRIEND.get(a.indu()) != null && (STATS.POP()).FRIEND.get(a.indu()) instanceof Humanoid);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\bio\BioLines.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */