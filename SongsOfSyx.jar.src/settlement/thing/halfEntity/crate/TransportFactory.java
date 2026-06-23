/*    */ package settlement.thing.halfEntity.crate;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import java.io.IOException;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.thing.halfEntity.Factory;
/*    */ import settlement.thing.halfEntity.HalfEntity;
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
/* 18 */     super(all);
/* 19 */     this.sprite = new Sprite();
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
/* 42 */     return new TransportEntity();
/*    */   }
/*    */   
/*    */   public void make(Humanoid h, int tx, int ty, RESOURCE res, byte ran, boolean mil) {
/* 46 */     TransportEntity e = (TransportEntity)create();
/* 47 */     e.init(h, tx, ty, res, ran, mil);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\crate\TransportFactory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */