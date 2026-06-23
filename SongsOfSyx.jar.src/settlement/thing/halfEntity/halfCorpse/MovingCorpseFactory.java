/*    */ package settlement.thing.halfEntity.halfCorpse;
/*    */ 
/*    */ import init.type.CAUSE_LEAVE;
/*    */ import java.io.IOException;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.thing.halfEntity.Factory;
/*    */ import settlement.thing.halfEntity.HalfEntity;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ public class MovingCorpseFactory
/*    */   extends Factory<MovingCorpse> {
/*    */   public MovingCorpseFactory(LISTE<Factory<?>> all) {
/* 15 */     super(all);
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
/*    */   protected MovingCorpse make() {
/* 39 */     return new MovingCorpse();
/*    */   }
/*    */   
/*    */   public void make(Humanoid h, boolean gore, CAUSE_LEAVE l) {
/* 43 */     MovingCorpse e = (MovingCorpse)create();
/* 44 */     e.init(h, gore, l);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\halfCorpse\MovingCorpseFactory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */