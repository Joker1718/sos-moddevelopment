/*    */ package game.event.actions;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.raiding.Raider;
/*    */ import game.raiding.RaidingMap;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.D;
/*    */ import world.army.AD;
/*    */ import world.region.RD;
/*    */ 
/*    */ final class _INVASION extends EventActionConstructor {
/* 22 */   private static CharSequence ¤¤arrive = "The army of {0} has now arrived.";
/*    */   
/*    */   static {
/* 25 */     D.ts(_INVASION.class);
/*    */   }
/*    */   
/*    */   _INVASION() {
/* 29 */     super("INVASION");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 35 */     return new Imp(this.key, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp
/*    */     extends EventAction {
/*    */     private final Race race;
/*    */     private final double amountFrom;
/*    */     private final double amountTo;
/*    */     
/*    */     Imp(String key, Json data, LISTE<EventAction> all) {
/* 45 */       super(key, all);
/* 46 */       this.race = (Race)RACES.map().readTry("RACE", data);
/* 47 */       this.amountFrom = data.d("AMOUNT_FROM", 0.0D, 1000.0D);
/* 48 */       this.amountTo = data.d("AMOUNT_TO", this.amountFrom, 1000.0D);
/* 49 */       data.checkUnused();
/*    */     }
/*    */ 
/*    */     
/*    */     public void exe(Event event, EContext data) {
/* 54 */       if (this.race == null) {
/*    */         return;
/*    */       }
/* 57 */       double pow = 0.0D;
/* 58 */       LIST<RaidingMap.RaidRegion> vv = (GAME.raiders()).entry.entryRegions();
/* 59 */       if (vv.size() > 0) {
/* 60 */         pow = Double.MAX_VALUE;
/* 61 */         for (RaidingMap.RaidRegion reg : vv) {
/*    */           
/* 63 */           double p = (RD.MILITARY()).power.getD(reg.r());
/* 64 */           if (p < pow)
/* 65 */             pow = p; 
/*    */         } 
/*    */       } 
/* 68 */       pow += AD.power().get((Faction)FACTIONS.player());
/* 69 */       pow *= this.amountFrom + RND.rFloat() * (this.amountTo - this.amountFrom);
/* 70 */       Raider rr = new Raider(this.race, pow);
/* 71 */       rr.text.set(rr, true);
/*    */       
/* 73 */       (GAME.raiders()).current.raid(rr, String.valueOf(Str.TMP.clear().add(_INVASION.¤¤arrive).insert(0, rr.name)));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_INVASION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */