/*    */ package game.boosting;
/*    */ 
/*    */ import snake2d.Errors;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ import util.keymap.RMAP;
/*    */ 
/*    */ final class Map extends RMAP<Boostable> {
/*    */   private final ArrayListGrower<Boostable> li;
/*    */   
/*    */   public Map() {
/* 13 */     super("BOOST", (LIST)new ArrayListGrower());
/* 14 */     this.li = (ArrayListGrower<Boostable>)all();
/*    */   }
/*    */   
/*    */   void clear() {
/* 18 */     this.li.clear();
/* 19 */     this.map.clear();
/*    */   }
/*    */   
/*    */   public void add(Boostable b) {
/* 23 */     if (this.map.containsKey(this.key))
/* 24 */       throw new Errors.GameError("Another boostable with the same key exists " + this.key); 
/* 25 */     this.li.add(b);
/* 26 */     this.map.put(b.key, b);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public KeyMap<Boostable> map() {
/* 32 */     return this.map;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\Map.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */