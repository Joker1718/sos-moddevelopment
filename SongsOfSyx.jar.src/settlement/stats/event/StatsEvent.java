/*    */ package settlement.stats.event;
/*    */ 
/*    */ import game.GAME;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STAT;
/*    */ import settlement.stats.stat.STATData;
/*    */ import settlement.stats.stat.StatCollection;
/*    */ import util.data.DataO;
/*    */ import util.data.INT_O;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StatsEvent
/*    */   extends StatCollection
/*    */ {
/*    */   private final STATData stat;
/*    */   boolean hasChange = true;
/*    */   public INT_O.INT_OE<Induvidual> mark;
/*    */   
/*    */   public StatsEvent(StatsInit init) {
/* 22 */     super(init, "EVENT", "", "");
/*    */     
/* 24 */     init.count.getClass(); this.stat = new STATData("EVENT", "EVENTD", init, (INT_O.INT_OE)new DataO.DataBit(init.count, "EVENT_STATUS"));
/* 25 */     init.count.getClass(); this.mark = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "EVENT_MARK");
/*    */     
/* 27 */     init.onArrival.add(new StatsInit.StatInitable()
/*    */         {
/*    */           public void init(Induvidual h)
/*    */           {
/* 31 */             if (GAME.EVENT().shouldSet(h)) {
/* 32 */               StatsEvent.this.stat.indu().set(h, 1);
/*    */             }
/*    */           }
/*    */         });
/*    */     
/* 37 */     init.upers.add(new StatsInit.StatUpdatable()
/*    */         {
/*    */           public void update(double ds) {}
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public STAT stat() {
/* 51 */     return (STAT)this.stat;
/*    */   }
/*    */   
/*    */   public boolean has(Induvidual t) {
/* 55 */     return (this.stat.indu().get(t) == 1);
/*    */   }
/*    */   
/*    */   public void set(Induvidual t, boolean has) {
/* 59 */     this.stat.indu().set(t, has ? 1 : 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\event\StatsEvent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */