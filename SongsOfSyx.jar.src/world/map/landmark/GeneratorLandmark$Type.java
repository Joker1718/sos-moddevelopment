/*     */ package world.map.landmark;
/*     */ 
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ abstract class Type
/*     */   implements MAP_BOOLEAN
/*     */ {
/*     */   private final String[] names;
/*     */   private final String[] addons;
/* 206 */   private int nameI = 0;
/*     */   private final Json[] specials;
/* 208 */   private int sI = 0;
/*     */   private int minSize;
/*     */   private int maxSize;
/*     */   
/*     */   Type(Json json, String key, int min, int max) {
/* 213 */     json = json.json(key);
/* 214 */     this.minSize = min;
/* 215 */     this.maxSize = max;
/* 216 */     this.names = json.texts("NAMES"); int i;
/* 217 */     for (i = 0; i < this.names.length; i++) {
/* 218 */       int k = RND.rInt(this.names.length);
/* 219 */       String o = this.names[i];
/* 220 */       this.names[i] = this.names[k];
/* 221 */       this.names[k] = o;
/*     */     } 
/* 223 */     this.addons = json.texts("ADDONS");
/* 224 */     this.specials = json.jsons("SPECIAL");
/*     */     
/* 226 */     for (i = 0; i < this.specials.length; i++) {
/* 227 */       int k = RND.rInt(this.specials.length);
/* 228 */       Json o = this.specials[i];
/* 229 */       this.specials[i] = this.specials[k];
/* 230 */       this.specials[k] = o;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 236 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void init(WorldLandmark l) {
/* 242 */     if (this.sI < this.specials.length) {
/* 243 */       l.name.clear().add(this.specials[this.sI].text("NAME"));
/* 244 */       l.description.clear().add(this.specials[this.sI].text("LORE"));
/* 245 */       if (l.description.length() > 1024)
/* 246 */         this.specials[this.sI].error("Lore is too long...", "LORE"); 
/* 247 */       this.sI++;
/*     */     }
/* 249 */     else if (this.names.length == 0) {
/* 250 */       l.name.clear().add(l.index);
/*     */     } else {
/* 252 */       if (this.addons.length > 0) {
/* 253 */         l.name.clear().add(this.addons[RND.rInt(this.addons.length)]);
/* 254 */         l.name.insert(0, this.names[this.nameI++]);
/*     */       } else {
/* 256 */         l.name.clear().add(this.names[this.nameI++]);
/* 257 */       }  if (this.nameI >= this.names.length)
/* 258 */         this.nameI = 0; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\GeneratorLandmark$Type.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */