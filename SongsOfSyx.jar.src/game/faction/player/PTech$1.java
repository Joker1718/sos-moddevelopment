/*     */ package game.faction.player;
/*     */ 
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import init.tech.TechCurrency;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements SAVABLE
/*     */ {
/*     */   public void save(FilePutter file) {
/* 210 */     file.i(TECHS.ALL().size());
/* 211 */     for (TECH t : TECHS.ALL()) {
/* 212 */       file.chars(t.key);
/* 213 */       file.i(PTech.this.level[t.index()]);
/*     */     } 
/*     */     
/* 216 */     file.i(PTech.this.currs.size());
/* 217 */     for (PTech.TechCurr c : PTech.this.currs) {
/* 218 */       file.chars(c.cu.bo.key);
/* 219 */       c.save(file);
/*     */     } 
/* 221 */     PTech.this.uper.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 226 */     int tS = file.i();
/*     */     
/* 228 */     Arrays.fill(PTech.this.level, 0);
/* 229 */     Arrays.fill(PTech.this.penalties, 0.0F);
/* 230 */     KeyMap<TECH> map = new KeyMap();
/* 231 */     for (TECH t : TECHS.ALL())
/* 232 */       map.put(t.key, t); 
/* 233 */     for (int i = 0; i < tS; i++) {
/* 234 */       String k = file.chars();
/* 235 */       int l = file.i();
/* 236 */       if (map.containsKey(k)) {
/* 237 */         PTech.this.level[((TECH)map.get(k)).index()] = CLAMP.i(l, 0, ((TECH)map.get(k)).levelMax);
/*     */       }
/*     */     } 
/*     */     
/* 241 */     KeyMap<PTech.TechCurr> cmap = new KeyMap();
/* 242 */     for (PTech.TechCurr c : PTech.this.currs) {
/* 243 */       c.clear();
/* 244 */       cmap.put(c.cu.bo.key, c);
/*     */     } 
/* 246 */     tS = file.i();
/*     */     
/* 248 */     for (int j = 0; j < tS; j++) {
/* 249 */       String k = file.chars();
/* 250 */       if (cmap.containsKey(k)) {
/* 251 */         ((PTech.TechCurr)cmap.get(k)).load(file);
/*     */       } else {
/* 253 */         (new PTech.TechCurr((TechCurrency)TECHS.COSTS().get(0))).load(file);
/*     */       } 
/*     */     } 
/* 256 */     PTech.this.uper.load(file);
/* 257 */     PTech.this.setBonuses();
/* 258 */     PTech.this.bos.clearChache();
/* 259 */     PTech.this.dirty = true;
/*     */   }
/*     */   
/*     */   public void clear() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTech$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */