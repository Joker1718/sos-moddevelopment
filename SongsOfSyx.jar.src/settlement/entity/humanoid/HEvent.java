/*     */ package settlement.entity.humanoid;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ECollision;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ public enum HEvent
/*     */ {
/*  21 */   MEET_HARMLESS,
/*  22 */   MEET_ENEMY,
/*  23 */   COLLISION_HARD,
/*  24 */   COLLISION_SOFT,
/*     */ 
/*     */ 
/*     */   
/*  28 */   COLLISION_TILE,
/*     */ 
/*     */ 
/*     */   
/*  32 */   CHECK_MORALE,
/*     */ 
/*     */ 
/*     */   
/*  36 */   EXHAUST,
/*  37 */   NOTIFY_CRIME,
/*  38 */   ROOM_REMOVED,
/*     */   
/*  40 */   COLLISION_UNREACHABLE,
/*  41 */   INTERRACT,
/*  42 */   FISHINGTRIP_OVER,
/*  43 */   ALERT_DANGER;
/*     */   
/*     */   static {
/*  46 */     all = (LIST<HEvent>)new ArrayList((Object[])values());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     event = new HEventData();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final LIST<HEvent> all;
/*     */   
/*     */   private static HEventData event;
/*     */ 
/*     */   
/*     */   public static final class HEventData
/*     */   {
/*     */     public HEvent event;
/*     */     
/*     */     public double norX;
/*     */     
/*     */     public double norY;
/*     */     
/*     */     public double momentum;
/*     */     public ENTITY other;
/*     */     public RoomInstance room;
/*     */     public double facingDot;
/*     */     public boolean broken;
/*     */     public int tx;
/*     */     public int ty;
/*     */     public boolean speedHasChanged;
/*     */   }
/*     */   
/*     */   public static class Handler
/*     */   {
/*     */     static boolean debug = false;
/*     */     
/*     */     static void collide(Humanoid a, AIManager ai, ECollision coll) {
/*  84 */       int time = (int)TIME.currentSecond();
/*     */       
/*  86 */       boolean hostile = !(coll.damagetileStrength <= 0.0D && (coll.other == null || !(coll.other instanceof Humanoid) || !HPoll.Handler.isEnemy(a, coll.other)));
/*     */       
/*  88 */       if (hostile) {
/*  89 */         ai.lastCollision = time;
/*  90 */       } else if (coll.other instanceof Humanoid) {
/*  91 */         ai.lastCollision = Math.max(ai.lastCollision, ((Humanoid)coll.other).ai.lastCollision);
/*     */       } 
/*  93 */       double mom = coll.tileMomentum * a.physics.getMassI() * 0.002232142857142857D;
/*     */       
/*  95 */       CAUSE_LEAVE l = coll.leave;
/*  96 */       if (l == null) {
/*  97 */         l = (coll.other instanceof Animal) ? CAUSE_LEAVES.ANIMAL() : CAUSE_LEAVES.SLAYED();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 102 */       if (mom > 4.0D) {
/* 103 */         a.inflictDamage(2.0D, l);
/* 104 */         if (a.isRemoved() && 
/* 105 */           coll.other instanceof Animal) {
/* 106 */           Animal an = (Animal)coll.other;
/* 107 */           (SETT.ANIMALS()).spawn.reportKillRevenge(an.species());
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 113 */       if (coll.damagetileStrength > 0.0D) {
/*     */ 
/*     */         
/* 116 */         double dam = (GAME.battle()).fight.getDamageDone(coll, a);
/*     */         
/* 118 */         if (dam > 0.0D && !a.inflictDamage(dam, l)) {
/* 119 */           if (a.isRemoved() && 
/* 120 */             coll.other instanceof Animal) {
/* 121 */             Animal an = (Animal)coll.other;
/* 122 */             (SETT.ANIMALS()).spawn.reportKillRevenge(an.species());
/*     */           } 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 131 */       HEvent.event.momentum = mom;
/* 132 */       HEvent.event.norX = coll.norX;
/* 133 */       HEvent.event.norY = coll.norY;
/* 134 */       HEvent.event.speedHasChanged = coll.speedHasChanged;
/*     */       
/* 136 */       if (mom > 1.0D) {
/* 137 */         HEvent.event.event = HEvent.COLLISION_HARD;
/* 138 */         ai.event(a, HEvent.event);
/*     */         return;
/*     */       } 
/* 141 */       HEvent.event.facingDot = coll.dirDot;
/* 142 */       HEvent.event.other = coll.other;
/*     */       
/* 144 */       if (coll.other instanceof Humanoid) {
/*     */         
/* 146 */         if (hostile) {
/* 147 */           HEvent.event.event = HEvent.MEET_ENEMY;
/*     */         }
/* 149 */         else if (mom > 0.0D) {
/* 150 */           HEvent.event.event = HEvent.COLLISION_SOFT;
/*     */         } else {
/* 152 */           HEvent.event.event = HEvent.MEET_HARMLESS;
/*     */         } 
/* 154 */         ai.event(a, HEvent.event);
/*     */       } else {
/* 156 */         if (mom > 0.0D || coll.other == null) {
/* 157 */           HEvent.event.event = HEvent.COLLISION_SOFT;
/*     */         } else {
/* 159 */           HEvent.event.event = HEvent.MEET_HARMLESS;
/* 160 */         }  ai.event(a, HEvent.event);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     static void meet(Humanoid a, AIManager ai, ENTITY other) {
/* 167 */       HEvent.event.event = HEvent.MEET_HARMLESS;
/* 168 */       HEvent.event.other = other;
/* 169 */       if (other instanceof Animal && (STATS.RAN().get(a.indu(), 0) & 0x1FF) == 0)
/* 170 */         (STATS.POP()).FRIEND.set(a.indu(), other); 
/* 171 */       ai.event(a, HEvent.event);
/*     */     }
/*     */ 
/*     */     
/*     */     public static void alertDanger(Humanoid a) {
/* 176 */       HEvent.event.event = HEvent.ALERT_DANGER;
/* 177 */       a.ai.event(a, HEvent.event);
/*     */     }
/*     */ 
/*     */     
/*     */     public static void notifyCrime(Humanoid a, ENTITY criminal) {
/* 182 */       HEvent.event.event = HEvent.NOTIFY_CRIME;
/* 183 */       HEvent.event.other = criminal;
/* 184 */       a.ai.event(a, HEvent.event);
/*     */     }
/*     */     
/*     */     public static void exhaust(Humanoid a) {
/* 188 */       HEvent.event.event = HEvent.EXHAUST;
/* 189 */       a.ai.event(a, HEvent.event);
/*     */     }
/*     */     
/*     */     public static void checkMorale(Humanoid a) {
/* 193 */       HEvent.event.event = HEvent.CHECK_MORALE;
/* 194 */       a.ai.event(a, HEvent.event);
/*     */     }
/*     */     
/*     */     public static void removeRoom(Humanoid a, RoomInstance room) {
/* 198 */       AI.modules().evictFromRoom(a, a.ai, (ROOMA)room);
/* 199 */       HEvent.event.event = HEvent.ROOM_REMOVED;
/* 200 */       HEvent.event.room = room;
/* 201 */       a.ai.event(a, HEvent.event);
/*     */     }
/*     */     
/*     */     public static void collisionUnreachable(Humanoid a) {
/* 205 */       HEvent.event.event = HEvent.COLLISION_UNREACHABLE;
/* 206 */       a.ai.event(a, HEvent.event);
/*     */     }
/*     */     
/*     */     public static void fishingTripOver(Humanoid a, double time) {
/* 210 */       HEvent.event.event = HEvent.FISHINGTRIP_OVER;
/* 211 */       HEvent.event.momentum = time;
/* 212 */       a.ai.event(a, HEvent.event);
/*     */     }
/*     */     
/*     */     public static boolean interract(Humanoid a, Humanoid friend) {
/* 216 */       HEvent.event.event = HEvent.INTERRACT;
/* 217 */       HEvent.event.other = friend;
/* 218 */       return a.ai.event(a, HEvent.event);
/*     */     }
/*     */     
/*     */     static boolean collideTile(Humanoid a, AIManager ai, double norX, double norY, double momentum, boolean broken, int tx, int ty) {
/* 222 */       momentum *= 0.002232142857142857D;
/* 223 */       HEvent.event.momentum = momentum;
/* 224 */       HEvent.event.norX = norX;
/* 225 */       HEvent.event.norY = norY;
/* 226 */       HEvent.event.speedHasChanged = true;
/* 227 */       if (momentum >= 1.0D) {
/* 228 */         HEvent.event.event = HEvent.COLLISION_HARD;
/* 229 */         ai.event(a, HEvent.event);
/* 230 */         return true;
/*     */       } 
/* 232 */       HEvent.event.event = HEvent.COLLISION_TILE;
/* 233 */       HEvent.event.tx = tx;
/* 234 */       HEvent.event.ty = ty;
/* 235 */       HEvent.event.broken = broken;
/* 236 */       return ai.event(a, HEvent.event);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\HEvent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */