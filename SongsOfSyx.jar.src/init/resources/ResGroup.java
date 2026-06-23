/*    */ package init.resources;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import snake2d.Errors;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import util.keymap.RMAPS;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ResGroup<T extends ResG>
/*    */ {
/*    */   public final RBIT mask;
/*    */   private final LIST<T> all;
/*    */   private final LIST<RESOURCE> resources;
/*    */   private int[] indexMap;
/*    */   public final String key;
/*    */   public final RMAPS<T> MAP;
/*    */   
/*    */   ResGroup(String key, LIST<T> resses) {
/* 22 */     this.key = key;
/* 23 */     this.all = (LIST<T>)new ArrayList((Iterable)resses);
/* 24 */     if (this.all.size() == 0)
/* 25 */       throw new Errors.DataError("not enough " + key + " resources have been declared"); 
/* 26 */     ArrayList<RESOURCE> ress = new ArrayList(resses.size());
/* 27 */     this.indexMap = Alloc.ii(RESOURCES.ALL().size());
/* 28 */     Arrays.fill(this.indexMap, -1);
/* 29 */     RBIT.RBITImp m = new RBIT.RBITImp();
/* 30 */     for (ResG resG : resses) {
/* 31 */       if (m.has(resG.resource.bit))
/* 32 */         throw new Errors.DataError("Several " + key + " is mapping to the same resource, and that doesn't work"); 
/* 33 */       ress.add(resG.resource);
/* 34 */       m.or(resG.resource.bit);
/* 35 */       this.indexMap[resG.resource.index()] = resG.index();
/*    */     } 
/* 37 */     this.resources = (LIST<RESOURCE>)ress;
/* 38 */     this.mask = m;
/* 39 */     this.MAP = new RMAPS(key, resses);
/*    */   }
/*    */   
/*    */   public LIST<RESOURCE> res() {
/* 43 */     return this.resources;
/*    */   }
/*    */   
/*    */   public boolean is(RESOURCE res) {
/* 47 */     return this.mask.has(res);
/*    */   }
/*    */   
/*    */   public LIST<T> all() {
/* 51 */     return this.all;
/*    */   }
/*    */   
/*    */   public T get(RESOURCE res) {
/* 55 */     if (this.mask.has(res.bit)) {
/* 56 */       return (T)this.all.get(this.indexMap[res.bIndex()]);
/*    */     }
/* 58 */     return null;
/*    */   }
/*    */   
/*    */   public RESOURCE[] makeArray() {
/* 62 */     RESOURCE[] rr = new RESOURCE[this.all.size()];
/* 63 */     for (ResG e : all())
/* 64 */       rr[e.index()] = e.resource; 
/* 65 */     return rr;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\ResGroup.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */