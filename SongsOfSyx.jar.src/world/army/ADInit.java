/*    */ package world.army;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import java.util.LinkedList;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.data.DataO;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ADInit
/*    */ {
/* 13 */   public final DataO<WArmy> dataA = new DataO<WArmy>("ADARMY")
/*    */     {
/*    */       protected long[] data(WArmy t) {
/* 16 */         return (t.divs()).data;
/*    */       }
/*    */     };
/* 19 */   public final DataO<Faction> dataT = new DataO<Faction>("ADFACTION")
/*    */     {
/*    */       protected long[] data(Faction t) {
/* 22 */         return (AD.army(t)).data;
/*    */       }
/*    */     };
/*    */   
/* 26 */   final LinkedList<Countable> countable = new LinkedList<>();
/* 27 */   final LinkedList<Register> registers = new LinkedList<>();
/* 28 */   final LinkedList<Updater> updaters = new LinkedList<>();
/* 29 */   final LinkedList<ACTION.ACTION_O<Faction>> inits = new LinkedList<>();
/*    */   
/*    */   static interface Countable {
/*    */     void count(WArmy param1WArmy, int param1Int);
/*    */   }
/*    */   
/*    */   static interface Register {
/*    */     void register(ADDiv param1ADDiv, int param1Int);
/*    */   }
/*    */   
/*    */   static interface Updater {
/*    */     void update(WArmy param1WArmy, double param1Double);
/*    */     
/*    */     void update(Faction param1Faction, double param1Double);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADInit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */