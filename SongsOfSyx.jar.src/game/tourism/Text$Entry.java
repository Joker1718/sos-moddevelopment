/*     */ package game.tourism;
/*     */ 
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Entry
/*     */ {
/* 156 */   private CharSequence[][] chars = new CharSequence[3][];
/*     */   private final int scroll;
/*     */   
/*     */   Entry(int index, Json json, String key) {
/* 160 */     this.scroll = index * 8;
/* 161 */     if (json != null) {
/* 162 */       json = json.json(key);
/* 163 */       this.chars[0] = Text.insert.check((CharSequence[])json.texts("BAD"));
/* 164 */       this.chars[1] = Text.insert.check((CharSequence[])json.texts("OK"));
/* 165 */       this.chars[2] = Text.insert.check((CharSequence[])json.texts("GOOD"));
/*     */     } else {
/* 167 */       (new CharSequence[1])[0] = ""; this.chars[0] = new CharSequence[1];
/* 168 */       (new CharSequence[1])[0] = ""; this.chars[1] = new CharSequence[1];
/* 169 */       (new CharSequence[1])[0] = ""; this.chars[2] = new CharSequence[1];
/*     */     } 
/*     */   }
/*     */   
/*     */   public Str get(Text.InsertData data) {
/* 174 */     int ri = (int)Math.round(data.rating * 2.0D - 0.25D);
/* 175 */     ri = CLAMP.i(ri, 0, 2);
/* 176 */     int r = STATS.RAN().get(data.i, this.scroll);
/* 177 */     Text.str.clear().add(this.chars[ri][MATH.mod(r, (this.chars[ri]).length)]);
/* 178 */     Text.insert.set(Text.str, data);
/* 179 */     return Text.str;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\Text$Entry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */