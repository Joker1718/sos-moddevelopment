/*     */ package game.event.actions;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import game.event.engine.Event;
/*     */ import game.event.engine.EventCollection;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
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
/*     */ class null
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/* 185 */     KeyMap<_BOOST.Cluster> map = new KeyMap();
/* 186 */     for (Event e : handler.all) {
/* 187 */       for (EventAction a : e.actions()) {
/* 188 */         if (a instanceof _BOOST.Imp) {
/* 189 */           _BOOST.Imp b = (_BOOST.Imp)a;
/* 190 */           for (BoostSpec s : new ArrayList((Iterable)b.player.all())) {
/* 191 */             String k = s.boostable.key() + s.boostable.key();
/* 192 */             if (!map.containsKey(k))
/* 193 */               map.put(k, new _BOOST.Cluster(s.boostable, s.booster.isMul)); 
/* 194 */             ((_BOOST.Cluster)map.get(k)).addA(b);
/*     */           } 
/* 196 */           for (BoostSpec s : new ArrayList((Iterable)b.subjects.all())) {
/* 197 */             String k = s.boostable.key() + s.boostable.key();
/* 198 */             if (!map.containsKey(k))
/* 199 */               map.put(k, new _BOOST.Cluster(s.boostable, s.booster.isMul)); 
/* 200 */             ((_BOOST.Cluster)map.get(k)).addB(b);
/*     */           } 
/* 202 */           for (BoostSpec s : new ArrayList((Iterable)b.regions.all())) {
/* 203 */             String k = s.boostable.key() + s.boostable.key();
/* 204 */             if (!map.containsKey(k))
/* 205 */               map.put(k, new _BOOST.Cluster(s.boostable, s.booster.isMul)); 
/* 206 */             ((_BOOST.Cluster)map.get(k)).addC(b);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     for (_BOOST.Cluster c : map.all())
/*     */     {
/* 217 */       c.add(c.target);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_BOOST$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */