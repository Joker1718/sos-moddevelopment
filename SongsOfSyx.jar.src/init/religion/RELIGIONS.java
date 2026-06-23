/*    */ package init.religion;
/*    */ 
/*    */ import init.INIT;
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import util.keymap.RMAP;
/*    */ 
/*    */ 
/*    */ public final class RELIGIONS
/*    */   extends INIT.InitResource
/*    */ {
/*    */   private static RELIGIONS self;
/* 15 */   private final ArrayListGrower<Religion> all = new ArrayListGrower();
/*    */   private final RMAP<Religion> MAP;
/*    */   
/*    */   public RELIGIONS(INIT init) throws IOException {
/* 19 */     super(init);
/* 20 */     self = this; byte b; int i;
/*    */     String[] arrayOfString;
/* 22 */     for (i = (arrayOfString = PATHS.INIT().getFolder("religion").getFiles()).length, b = 0; b < i; ) { String k = arrayOfString[b];
/* 23 */       Religion r = new Religion(k, this.all.size());
/* 24 */       this.all.add(r);
/*    */       
/*    */       b++; }
/*    */     
/* 28 */     this.MAP = new RMAP("RELIGION", (LIST)this.all);
/* 29 */     for (Religion r : this.all) {
/* 30 */       r.init();
/*    */     }
/*    */   }
/*    */   
/*    */   public static LIST<Religion> ALL() {
/* 35 */     return (LIST<Religion>)self.all;
/*    */   }
/*    */   
/*    */   public static RMAP<Religion> MAP() {
/* 39 */     return self.MAP;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\religion\RELIGIONS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */