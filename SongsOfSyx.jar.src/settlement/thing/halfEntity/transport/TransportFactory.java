/*    */ package settlement.thing.halfEntity.transport;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import java.io.IOException;
/*    */ import settlement.thing.halfEntity.Factory;
/*    */ import settlement.thing.halfEntity.HalfEntity;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ public class TransportFactory
/*    */   extends Factory<TransportEntity>
/*    */ {
/*    */   public final Sprite sprite;
/*    */   
/*    */   public TransportFactory(LISTE<Factory<?>> all) throws IOException {
/* 19 */     super(all);
/* 20 */     this.sprite = new Sprite();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clear() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected TransportEntity make() {
/* 43 */     return new TransportEntity();
/*    */   }
/*    */   
/*    */   public boolean military(int tx, int ty, byte ran, RESOURCE res, int ramount, DIR d) {
/* 47 */     TransportEntity e = (TransportEntity)create();
/* 48 */     return e.initMilitary(tx, ty, ran, res, ramount, d);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean loader(int tx, int ty, byte ran, RESOURCE res, int ramount, DIR d, COORDINATE station) {
/* 63 */     TransportEntity e = (TransportEntity)create();
/* 64 */     return e.initStation(tx, ty, ran, res, ramount, d, station);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\transport\TransportFactory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */