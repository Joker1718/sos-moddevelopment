/*    */ package game.event.engine;
/*    */ 
/*    */ import init.value.GValueCat;
/*    */ import init.value.Lockable;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayListGrower;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ESelectionType<T>
/*    */ {
/* 39 */   public ArrayListGrower<Lockable<T>> filters = new ArrayListGrower();
/*    */   EAmount min;
/*    */   EAmount max;
/*    */   public boolean useAsIcon = false;
/* 43 */   public ESelection.ESelectionMark mark = new ESelection.ESelectionMark();
/*    */   
/*    */   public ESelectionType() {
/* 46 */     this.min = new EAmount(0);
/* 47 */     this.max = new EAmount(2147483647);
/*    */   }
/*    */   
/*    */   void read(Json data, String key, GValueCat<T> ll) {
/* 51 */     if (data.has(key)) {
/* 52 */       Json dd = data.json(key);
/* 53 */       this.min = am(dd, "MIN_AMOUNT", 0);
/* 54 */       this.max = am(dd, "MAX_AMOUNT", 2147483647);
/* 55 */       if (dd.has("FILTERS")) {
/* 56 */         byte b; int i; Json[] arrayOfJson; for (i = (arrayOfJson = dd.jsons("FILTERS")).length, b = 0; b < i; ) { Json j = arrayOfJson[b];
/* 57 */           Lockable<T> lock = ll.LOCK.push();
/* 58 */           lock.pushPush(j);
/* 59 */           this.filters.add(lock); b++; }
/*    */       
/*    */       } 
/* 62 */       this.useAsIcon = dd.bool("USE_AS_ICON", false);
/* 63 */       this.mark.read(dd);
/* 64 */       dd.checkUnused();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private EAmount am(Json data, String key, int fallback) {
/* 70 */     if (data.has(key)) {
/* 71 */       Json json = data.json(key);
/* 72 */       return new EAmount(json, 0);
/*    */     } 
/* 74 */     return new EAmount(fallback);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\ESelection$ESelectionType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */