/*     */ package util.text;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends Inserter<Integer>.II
/*     */ {
/*     */   null(Inserter paramInserter, String $anonymous0) {
/* 144 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void set(Integer t, Str str) {
/* 148 */     int tot = 0;
/* 149 */     for (RoomBlueprintIns<?> in : (Iterable<RoomBlueprintIns<?>>)SETT.ROOMS().ins()) {
/* 150 */       if (in instanceof RoomBlueprintIns) {
/* 151 */         tot += in.instancesSize();
/*     */       }
/*     */     } 
/* 154 */     tot &= t.intValue() & Integer.MAX_VALUE;
/*     */     
/* 156 */     for (RoomBlueprintIns<?> in : (Iterable<RoomBlueprintIns<?>>)SETT.ROOMS().ins()) {
/* 157 */       if (in instanceof RoomBlueprintIns) {
/* 158 */         if (tot >= in.instancesSize()) {
/* 159 */           tot -= in.instancesSize(); continue;
/*     */         } 
/* 161 */         str.add((CharSequence)in.getInstance(tot).name());
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 169 */     str.add("no rooms");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertPlayer$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */