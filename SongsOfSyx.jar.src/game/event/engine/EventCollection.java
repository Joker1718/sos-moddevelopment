/*     */ package game.event.engine;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.event.actions.EventActions;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import snake2d.Errors;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ public class EventCollection
/*     */ {
/*  16 */   private final KeyMap<Event> map = new KeyMap();
/*  17 */   public final ArrayListGrower<Event> all = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean hasError;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EventCollection(PATHS.ResFolder fo) throws IOException {
/*  85 */     this.hasError = false; if (GAME.EVENT() != null)
/*     */       throw new Errors.DataError("This must be done before events are setup");  KeyMap<Integer> occMap = new KeyMap(); byte b; int i; String[] arrayOfString1; for (i = (arrayOfString1 = fo.init.getFiles()).length, b = 0; b < i; ) { String file = arrayOfString1[b]; Json jfile = new Json(fo.init.gets(file)); Json jtext = fo.text.exists(file) ? new Json(fo.text.gets(file)) : null; for (String pkey : jfile.keys()) { String key = file + "_" + file; Json text = (jtext != null && jtext.has(pkey)) ? jtext.json(pkey) : null; Json d = jfile.json(pkey); this.map.put(key, new Event((LISTE<Event>)this.all, key, d, text)); if (d.has("OCCURENCE")) { d = d.json("OCCURENCE"); if (d.has("TYPE")) { int k = 0; String t = d.value("TYPE"); if (occMap.containsKey(t))
/*     */               k += ((Integer)occMap.get(t)).intValue();  occMap.putReplace(t, Integer.valueOf(k)); }  }  }  b++; }  EventActions actions = new EventActions(this); String[] arrayOfString2; for (int j = (arrayOfString2 = fo.init.getFiles()).length; i < j; ) { String file = arrayOfString2[i]; Json jfile = new Json(fo.init.gets(file)); Json jtext = fo.text.exists(file) ? new Json(fo.text.gets(file)) : null; for (String pkey : jfile.keys()) { String key = file + "_" + file; Json d = jfile.json(pkey); Json text = (jtext != null && jtext.has(pkey)) ? jtext.json(pkey) : null; ((Event)this.map.get(key)).read(d, text, actions, this); if (d.has("OCCURENCE")) { d = d.json("OCCURENCE"); if (d.has("TYPE")) { int k = ((Integer)occMap.get(d.value("TYPE"))).intValue(); for (int di = 0; di < ((Event)this.map.get(key)).occurence.coccurence.length; di++)
/*     */               ((Event)this.map.get(key)).occurence.coccurence[di] = ((Event)this.map.get(key)).occurence.coccurence[di] / k;  }  }  }  i++; }
/*  89 */      actions.init(); } public Event read(Event parent, String k, Json error, String kk) { Event e = (Event)this.map.get(k);
/*  90 */     if (e == null) {
/*  91 */       String f = parent.key.split("_")[0];
/*  92 */       e = (Event)this.map.get(f + "_" + f);
/*     */     } 
/*  94 */     if (e == null) {
/*     */       
/*  96 */       String ee = error.errorGet("no event named: " + k + (k.endsWith(" ") ? "It ends with space!" : "") + k, kk);
/*     */       
/*  98 */       if (!this.hasError) {
/*  99 */         String av = "   Available: " + System.lineSeparator();
/* 100 */         av = av + av;
/* 101 */         ee = ee + ee + System.lineSeparator();
/* 102 */         this.hasError = true;
/*     */       } 
/*     */       
/* 105 */       LOG.err(ee);
/* 106 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 110 */     return e; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EventCollection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */