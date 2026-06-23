/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ class PreventSwitchtableIntAlloc
/*     */ {
/*     */   public static boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*     */     int tx;
/*     */     int ty;
/*     */     double s;
/*  60 */     switch (e.event) {
/*     */       case COLLISION_HARD:
/*  62 */         d.interrupt(a, e);
/*  63 */         d.overwrite(a, (AI.listeners()).PUSHED.push(d, a, e.momentum));
/*  64 */         return false;
/*     */       case COLLISION_SOFT:
/*  66 */         d.interrupt(a, e);
/*  67 */         d.overwrite(a, (AI.listeners()).STOP.activate(a, d));
/*  68 */         return false;
/*     */       case COLLISION_TILE:
/*  70 */         d.interrupt(a, e);
/*  71 */         d.overwrite(a, (AI.SUBS()).confused.activate(a, d));
/*  72 */         return true;
/*     */       case MEET_ENEMY:
/*  74 */         if (a.division() == null) {
/*  75 */           int i = a.physics.tileC().x();
/*  76 */           int j = a.physics.tileC().y();
/*  77 */           if (RND.oneIn(3) && (SETT.PATH()).finders.entity.getFriendlies(a, i, j) > (SETT.PATH()).finders.entity.getEnemies(a, i, j) / 4) {
/*  78 */             AIEventListeners.tmp = e.other;
/*  79 */             d.overwrite(a, (AI.listeners()).fight);
/*     */           } else {
/*  81 */             d.overwrite(a, (AI.plans()).runToSafety);
/*     */           } 
/*     */         } else {
/*  84 */           AIEventListeners.tmp = e.other;
/*  85 */           d.overwrite(a, (AI.listeners()).fight);
/*     */         } 
/*  87 */         return false;
/*     */       case MEET_HARMLESS:
/*  89 */         if (a.speed.dot(e.other.speed.nX(), e.other.speed.nY()) < 0.5D) {
/*  90 */           double t = a.speed.magnitudeTarget() * 0.5D;
/*  91 */           if (a.speed.magnitude() > t) {
/*  92 */             a.speed.magnitudeInit(t);
/*     */           }
/*     */         } 
/*  95 */         if (a.speed.magnitude() < e.other.speed.magnitude()) {
/*  96 */           double t = a.speed.magnitudeTarget() * 0.5D;
/*  97 */           if (a.speed.magnitude() > t) {
/*  98 */             a.speed.magnitudeInit(t);
/*     */           }
/*     */         } 
/* 101 */         return false;
/*     */       case CHECK_MORALE:
/* 103 */         tx = a.physics.tileC().x();
/* 104 */         ty = a.physics.tileC().y();
/* 105 */         if (a.division() == null && GAME.ARMIES().enemy().men() > 0 && (SETT.PATH()).finders.entity.getEnemies(a, tx, ty) > 0) {
/* 106 */           d.overwrite(a, (AI.plans()).runToSafety);
/* 107 */         } else if (a.division() != null && !(AI.modules()).battle.is(a, d)) {
/* 108 */           int p = (AI.modules()).battle.getPriority(a, d);
/* 109 */           if (p > 0) {
/* 110 */             AIModule m = AIModules.current(d);
/* 111 */             if (m == null || m.getPriority(a, d) < p) {
/* 112 */               d.overwrite(a, (AI.modules()).battle.interrrupt(a, d));
/* 113 */               (AIModules.data()).currentModule.set(d, (AI.modules()).battle.index());
/*     */             } 
/*     */           } 
/* 116 */           (AIModules.data()).nextModule.set(d, (AI.modules()).battle.index());
/*     */         } 
/* 118 */         return false;
/*     */       
/*     */       case null:
/* 121 */         AIEventListeners.tmp = null;
/* 122 */         d.overwrite(a, (AI.listeners()).flee);
/* 123 */         return true;
/*     */       case EXHAUST:
/* 125 */         s = a.speed.magnitudeRelative();
/* 126 */         if ((STATS.NEEDS()).EXHASTION.indu().getD(a.indu()) > 0.5D && AIModules.current(d).getPriority(a, d) <= 5) {
/* 127 */           d.overwrite(a, (AI.listeners()).exhausted);
/*     */         }
/* 129 */         if (s > 0.75D) {
/* 130 */           (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), 2);
/* 131 */         } else if (s <= 0.6D && RND.oneIn(16)) {
/* 132 */           (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), -1);
/*     */         } 
/* 134 */         return false;
/*     */       case NOTIFY_CRIME:
/* 136 */         if ((AI.modules()).work.isLawEnforcement(a, d)) {
/* 137 */           AIEventListeners.tmp = e.other;
/* 138 */           d.overwrite(a, (AI.listeners()).followCriminal);
/*     */         }
/* 140 */         else if (a.indu().hType() != HTYPES.PRISONER()) {
/* 141 */           AIEventListeners.tmp = e.other;
/* 142 */           d.overwrite(a, (AI.listeners()).flee);
/*     */         } 
/* 144 */         return false;
/*     */       case ROOM_REMOVED:
/* 146 */         return false;
/*     */       case COLLISION_UNREACHABLE:
/* 148 */         return false;
/*     */       case INTERRACT:
/* 150 */         if (HPoll.Handler.canInterract(a, e.other)) {
/* 151 */           d.otherEntitySet((Humanoid)e.other);
/* 152 */           d.overwrite(a, (AI.modules()).idle.interract());
/* 153 */           return true;
/*     */         } 
/* 155 */         return false;
/*     */       case FISHINGTRIP_OVER:
/* 157 */         return false;
/*     */     } 
/*     */ 
/*     */     
/* 161 */     return false;
/*     */   }
/*     */   
/*     */   public static double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 165 */     switch (e.type) {
/*     */       case WILL_COLLIDE_WITH:
/* 167 */         if (e.other instanceof Animal) {
/* 168 */           if (!((Animal)e.other).domesticated())
/* 169 */             return 1.0D; 
/* 170 */           return 0.0D;
/*     */         } 
/* 172 */         if (e.other instanceof Humanoid) {
/* 173 */           return ((((Humanoid)e.other).indu().hostile() != a.indu().hostile()) ? true : false);
/*     */         }
/* 175 */         return 0.0D;
/*     */       
/*     */       case DEFENCE_SKILL:
/* 178 */         return 0.1D * (0.1D + 0.9D * e.facingDot);
/*     */       case null:
/* 180 */         return 0.0D;
/*     */       case SCARE_ANIMAL_NOT:
/* 182 */         return 0.0D;
/*     */       case IMPACT_DAMAGE:
/* 184 */         return 0.0D;
/*     */       case WORKING:
/* 186 */         return 0.0D;
/*     */       case IS_SLAVE_READY_FOR_UPRISING:
/* 188 */         return -1.0D;
/*     */       case IS_ENEMY:
/* 190 */         if (e.other instanceof Humanoid) {
/* 191 */           Humanoid o = (Humanoid)e.other;
/* 192 */           if (o.indu().hostile() != a.indu().hostile()) {
/* 193 */             return 1.0D;
/*     */           }
/*     */         } 
/* 196 */         return 0.0D;
/*     */       case CAN_INTERRACT:
/* 198 */         return 0.0D;
/*     */       case COLLIDES:
/* 200 */         return 1.0D;
/*     */       case PARRY_SKILL:
/* 202 */         return 0.0D;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIEventListeners$PreventSwitchtableIntAlloc.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */