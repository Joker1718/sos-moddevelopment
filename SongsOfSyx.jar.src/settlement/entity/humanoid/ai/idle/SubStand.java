/*     */ package settlement.entity.humanoid.ai.idle;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIEventListeners;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ class SubStand
/*     */   extends AISUB.Simple
/*     */ {
/*  22 */   private final Inter inter = new Inter();
/*     */   private final AIPLAN plan;
/*     */   
/*     */   public SubStand(AIPLAN plan, String key) {
/*  26 */     super(key);
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
/*  91 */     this.sub = (AISUB)new AISUB.Simple("standMakeWay", "making way")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/*  95 */           d.subByte = (byte)(d.subByte + 1);
/*  96 */           switch (d.subByte) { case 1:
/*  97 */               return (AI.STATES()).STOP.instant(a, d);
/*  98 */             case 2: return (AI.STATES()).WALK2.cTile(a, d);
/*  99 */             case 3: return (AI.STATES()).STAND.activate(a, d, 0.5D);
/*     */             case 4:
/* 101 */               if (d.subPathByte >= DIR.ALL.size() || d.subPathByte < 0)
/* 102 */                 return (AI.STATES()).STOP.activate(a, d); 
/* 103 */               a.speed.setDirCurrent((DIR)DIR.ALL.get(d.subPathByte));
/* 104 */               return (AI.STATES()).WALK2.dirTile(a, d, a.speed.dir());
/* 105 */             case 5: a.speed.magnitudeInit(0.0D); return (AI.STATES()).STOP.activate(a, d);
/* 106 */             case 6: return (AI.STATES()).STAND.activate(a, d, (15.0F + RND.rFloat(5.0D)));
/* 107 */             case 7: return (AI.STATES()).STOP.instant(a, d);
/* 108 */             case 8: return null; }
/*     */           
/* 110 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 115 */     this.subMoveaway = (AISUB)new AISUB.Simple("standMoveAway", "making way")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 119 */           d.subByte = (byte)(d.subByte + 1);
/* 120 */           switch (d.subByte) {
/*     */             case 1:
/* 122 */               (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/* 123 */               return (AI.STATES()).STOP.instant(a, d);
/* 124 */             case 2: return (AI.STATES()).STAND.activate(a, d, 1.0D);
/*     */             case 3:
/* 126 */               if ((SETT.PATH()).finders.getOutofWay.checkAndSetRequest(a.tc().x(), a.tc().y(), d.path) && 
/* 127 */                 d.path.isSuccessful()) {
/* 128 */                 d.overwrite(a, (AI.SUBS()).walkTo.path(a, d));
/*     */               }
/*     */             case 4:
/* 131 */               return (AI.STATES()).STOP.activate(a, d);
/* 132 */             case 5: return (AI.STATES()).STAND.activate(a, d, (3.0F + RND.rFloat(3.0D)));
/*     */           } 
/* 134 */           return null;
/*     */         }
/*     */       };
/*     */     this.plan = plan;
/*     */   }
/*     */   
/*     */   private final AISUB sub;
/*     */   private final AISUB subMoveaway;
/*     */   
/*     */   public AISTATE resume(Humanoid a, AIManager d) {
/*     */     if (!a.speed.isZero())
/*     */       return (AI.STATES()).STOP.instant(a, d); 
/*     */     switch (d.subByte) {
/*     */       case 0:
/*     */         d.subByte = 1;
/*     */         if ((AI.STATES()).WALK2.cTileNeeds(a, d))
/*     */           return (AI.STATES()).WALK2.cTile(a, d); 
/*     */         return (AI.STATES()).STOP.instant(a, d);
/*     */       case 1:
/*     */         d.subByte = 2;
/*     */         return (AI.STATES()).STAND.activate(a, d, (1.0F + RND.rFloat(2.0D)));
/*     */       case 2:
/*     */         d.subByte = 100;
/*     */         a.speed.setRaw(a.speed.dir().next(1 * (RND.rBoolean() ? 1 : -1)), 0.0D);
/*     */         return (AI.STATES()).STAND.activate(a, d, (1.0F + RND.rFloat(2.0D)));
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/*     */     return this.inter.poll(a, d, e);
/*     */   }
/*     */   
/*     */   public boolean event(Humanoid a, AIManager ai, HEvent.HEventData e) {
/*     */     if (e.event == HEvent.MEET_HARMLESS) {
/*     */       if (e.other instanceof Humanoid) {
/*     */         Humanoid o = (Humanoid)e.other;
/*     */         AIManager oai = (AIManager)o.ai();
/*     */         if (oai.plan() == this.plan)
/*     */           return false; 
/*     */       } 
/*     */       COORDINATE c = a.physics.tileC();
/*     */       DIR d = e.other.speed.dir();
/*     */       int dd = RND.rBoolean() ? 1 : -1;
/*     */       d = d.next(-2 * dd);
/*     */       for (int i = 0; i < 5; i++) {
/*     */         if ((SETT.PATH()).coster.player.getCost(c.x(), c.y(), c.x() + d.x(), c.y() + d.y()) > 0.0D && (SETT.PATH()).finders.isGoodTileToStandOn(c.x() + d.x(), c.y() + d.y(), (ENTITY)a) && !(SETT.ROOMS()).map.is(c, d)) {
/*     */           a.speed.setDirCurrent(d);
/*     */           ai.subPathByte = (byte)d.id();
/*     */           ai.interrupt(a, e);
/*     */           ai.overwrite(a, this.sub.activate(a, ai));
/*     */           return false;
/*     */         } 
/*     */         d = d.next(-dd);
/*     */       } 
/*     */       ai.interrupt(a, e);
/*     */       ai.overwrite(a, this.subMoveaway.activate(a, ai));
/*     */     } 
/*     */     return AIEventListeners.def.event(a, ai, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\SubStand.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */