/*     */ package init.value;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ public final class Locks
/*     */ {
/* 143 */   final KeyMap<Lockable<T>> map = new KeyMap();
/* 144 */   LinkedList<ACTION> inits = new LinkedList();
/*     */   private Locks() {
/* 146 */     this.empty = new Lockable<>("", "", "", (SPRITE)(UI.icons()).s.DUMMY, paramGValueCat);
/*     */   }
/*     */   boolean hasSpewed = false;
/*     */   public final Lockable<T> empty;
/*     */   
/*     */   public void init() {
/* 152 */     for (ACTION a : this.inits)
/* 153 */       a.exe(); 
/* 154 */     this.inits.clear();
/*     */   }
/*     */   
/*     */   void clear() {
/* 158 */     this.map.clear();
/* 159 */     this.inits.clear();
/* 160 */     this.hasSpewed = false;
/*     */   }
/*     */   
/*     */   public Lockable<T> get(String key) {
/* 164 */     return (Lockable<T>)this.map.get(key);
/*     */   }
/*     */   
/*     */   public String available() {
/* 168 */     return this.map.keysString();
/*     */   }
/*     */   
/*     */   public Lockable<T> push(String key, CharSequence name, CharSequence desc, SPRITE icon) {
/* 172 */     key = key.replace("__", "_");
/* 173 */     Lockable<T> t = new Lockable<>(key, name, desc, icon, GValueCat.this);
/* 174 */     this.map.put(key, t);
/* 175 */     return t;
/*     */   }
/*     */   
/*     */   public Lockable<T> push() {
/* 179 */     Lockable<T> t = new Lockable<>("", "", "", (SPRITE)(UI.icons()).s.DUMMY, GValueCat.this);
/* 180 */     return t;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\GValueCat$Locks.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */