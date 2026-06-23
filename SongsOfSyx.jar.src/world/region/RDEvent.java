/*    */ package world.region;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import util.data.DataO;
/*    */ import util.data.INT_O;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RDEvent
/*    */ {
/*    */   private int am;
/*    */   public final INT_O.INT_OE<Region> ii;
/*    */   public final INT_O.INT_OE<Region> mark;
/*    */   
/*    */   RDEvent(RD.RDInit init) {
/* 23 */     String key = "EVENT_MARK";
/* 24 */     init.count.getClass(); this.ii = (INT_O.INT_OE<Region>)new DataO<Region>.DataBit(init.count, key)
/*    */       {
/*    */         public void set(Region t, int s) {
/* 27 */           RDEvent.this.am -= get(t);
/* 28 */           super.set(t, s);
/* 29 */           RDEvent.this.am += get(t);
/*    */         }
/*    */ 
/*    */         
/*    */         public int get(Region t) {
/* 34 */           if (t == null)
/* 35 */             return RDEvent.this.am; 
/* 36 */           return super.get(t);
/*    */         }
/*    */       };
/*    */     
/* 40 */     init.count.getClass(); this.mark = (INT_O.INT_OE<Region>)new DataO.DataShort(init.count, "EVENT");
/*    */     
/* 42 */     init.savable.add(new SAVABLE()
/*    */         {
/*    */           public void save(FilePutter file) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           public void load(FileGetter file) throws IOException {
/* 52 */             RDEvent.this.am = 0;
/* 53 */             for (Region reg : WORLD.REGIONS().all()) {
/* 54 */               RDEvent.this.am += RDEvent.this.ii.get(reg);
/*    */             }
/*    */           }
/*    */ 
/*    */           
/*    */           public void clear() {
/* 60 */             RDEvent.this.am = 0;
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int total() {
/* 70 */     return this.am;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDEvent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */