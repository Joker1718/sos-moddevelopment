/*     */ package script;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import snake2d.Errors;
/*     */ import snake2d.LOG;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GBox;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScriptEngine
/*     */   extends GAME.GameResource
/*     */ {
/*  25 */   private ArrayListGrower<Script> loads = new ArrayListGrower();
/*     */   private static LIST<ScriptLoad> all;
/*     */   
/*     */   public ScriptEngine(String[] scripts) {
/*  29 */     super("SCRIPTS", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     this.init = new SCRIPT()
/*     */       {
/*     */         public CharSequence name()
/*     */         {
/* 225 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isSelectable() {
/* 230 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public void initBeforeGameCreated() {
/* 235 */           for (ScriptEngine.Script s : ScriptEngine.this.loads) {
/*     */             try {
/* 237 */               s.load.script.initBeforeGameCreated();
/* 238 */             } catch (Exception e) {
/* 239 */               ScriptEngine.this.error(s.load, e);
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/*     */         public CharSequence desc() {
/* 245 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public SCRIPT.SCRIPT_INSTANCE createInstance() {
/* 250 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public void initBeforeGameInited() {
/* 255 */           for (ScriptEngine.Script s : ScriptEngine.this.loads) {
/*     */             try {
/* 257 */               s.load.script.initBeforeGameInited();
/* 258 */             } catch (Exception e) {
/* 259 */               ScriptEngine.this.error(s.load, e);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 266 */     this.callback = new SCRIPT.SCRIPT_INSTANCE()
/*     */       {
/*     */         public void update(double ds)
/*     */         {
/* 270 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverTimer(double mouseTimer, GBox text) {
/* 275 */           for (ScriptEngine.Script s : ScriptEngine.this.loads) {
/*     */             try {
/* 277 */               s.ins.hoverTimer(mouseTimer, text);
/* 278 */             } catch (Exception e) {
/* 279 */               ScriptEngine.this.error(s.load, e);
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/*     */         public void render(Renderer r, float ds) {
/* 285 */           for (ScriptEngine.Script s : ScriptEngine.this.loads) {
/*     */             try {
/* 287 */               s.ins.render(r, ds);
/* 288 */             } catch (Exception e) {
/* 289 */               ScriptEngine.this.error(s.load, e);
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/*     */         public void mouseClick(MButt button) {
/* 295 */           for (ScriptEngine.Script s : ScriptEngine.this.loads) {
/*     */             try {
/* 297 */               s.ins.mouseClick(button);
/* 298 */             } catch (Exception e) {
/* 299 */               ScriptEngine.this.error(s.load, e);
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/*     */         public void hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 305 */           for (ScriptEngine.Script s : ScriptEngine.this.loads) {
/*     */             try {
/* 307 */               s.ins.hover(mCoo, mouseHasMoved);
/* 308 */             } catch (Exception e) {
/* 309 */               ScriptEngine.this.error(s.load, e);
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/*     */         public void save(FilePutter file) {
/* 315 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 320 */           throw new RuntimeException();
/*     */         }
/*     */       };
/*     */     LOG.ln("adding scripts " + scripts.length);
/*     */     KeyMap<Boolean> map = new KeyMap();
/*     */     byte b;
/*     */     int i;
/*     */     String[] arrayOfString1;
/*     */     for (i = (arrayOfString1 = scripts).length, b = 0; b < i; ) {
/*     */       String s = arrayOfString1[b];
/*     */       if (!map.containsKey(s))
/*     */         map.put(s, Boolean.valueOf(false)); 
/*     */       b++;
/*     */     } 
/*     */     LIST<ScriptLoad> loads = ScriptLoad.getAll();
/*     */     for (ScriptLoad l : loads) {
/*     */       if (map.containsKey(l.key) || l.script.forceInit()) {
/*     */         map.putReplace(l.key, Boolean.valueOf(true));
/*     */         LOG.ln("adding script: " + l.file + " " + l.className + " " + l.script.forceInit());
/*     */         Script sc = new Script(l);
/*     */         this.loads.add(sc);
/*     */       } 
/*     */     } 
/*     */     String[] arrayOfString2;
/*     */     for (int j = (arrayOfString2 = scripts).length; i < j; ) {
/*     */       String s = arrayOfString2[i];
/*     */       if (!((Boolean)map.get(s)).booleanValue())
/*     */         GAME.Warn("Could not find script: " + s); 
/*     */       i++;
/*     */     } 
/*     */     this.init.initBeforeGameCreated();
/*     */   }
/*     */   
/*     */   public final SCRIPT init;
/*     */   public final SCRIPT.SCRIPT_INSTANCE callback;
/*     */   
/*     */   public void init(GAME game) {
/*     */     for (Script s : this.loads) {
/*     */       try {
/*     */         s.ins = s.load.script.createInstance();
/*     */       } catch (Exception e) {
/*     */         error(s.load, e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String[] currentScripts() {
/*     */     String[] scripts = new String[this.loads.size()];
/*     */     int i = 0;
/*     */     for (Script l : this.loads)
/*     */       scripts[i++] = l.load.key; 
/*     */     return scripts;
/*     */   }
/*     */   
/*     */   private void error(ScriptLoad l, Exception e) {
/*     */     StringWriter writer = new StringWriter();
/*     */     PrintWriter out = new PrintWriter(writer);
/*     */     out.append("error in script " + l.className);
/*     */     out.append(System.lineSeparator());
/*     */     e.printStackTrace(out);
/*     */     throw new Errors.DataError(writer.toString(), l.file);
/*     */   }
/*     */   
/*     */   public static LIST<ScriptLoad> getAll() {
/*     */     if (all == null)
/*     */       all = ScriptLoad.getAll(); 
/*     */     return all;
/*     */   }
/*     */   
/*     */   public static LIST<ScriptLoad> getInJar(String jarFile) {
/*     */     ArrayListGrower<ScriptLoad> res = new ArrayListGrower();
/*     */     for (ScriptLoad l : getAll()) {
/*     */       if (l.file.equals(jarFile))
/*     */         res.add(l); 
/*     */     } 
/*     */     return (LIST<ScriptLoad>)res;
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) {
/*     */     file.mark(this);
/*     */     file.i(this.loads.size());
/*     */     for (Script s : this.loads) {
/*     */       file.chars(s.load.key);
/*     */       int pos = file.getPosition();
/*     */       file.i(0);
/*     */       s.ins.save(file);
/*     */       int size = file.getPosition() - pos - 4;
/*     */       file.setAtPosition(pos, size);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*     */     file.check(this);
/*     */     int am = file.i();
/*     */     KeyMap<Script> map = new KeyMap();
/*     */     for (Script s : this.loads)
/*     */       map.put(s.load.key, s); 
/*     */     while (am-- > 0) {
/*     */       String key = file.chars();
/*     */       int size = file.i();
/*     */       int position = file.getPosition();
/*     */       if (map.containsKey(key)) {
/*     */         Script l = (Script)map.get(key);
/*     */         try {
/*     */           l.ins.load(file);
/*     */         } catch (Exception e) {
/*     */           error(l.load, e);
/*     */         } 
/*     */         if (size != file.getPosition() - position) {
/*     */           LOG.ln("Unable to load script. Was saved with + " + size + " bytes, but read " + file.getPosition() - position + " " + l.ins.hashCode());
/*     */           file.setPosition(position + size);
/*     */           if (l.ins.handleBrokenSavedState())
/*     */             LOG.ln("Script wants to carry on anyway, so be it."); 
/*     */         } 
/*     */         continue;
/*     */       } 
/*     */       LOG.ln("Script does not exist. Skipping. " + size + " " + key);
/*     */       for (int i = 0; i < size; i++)
/*     */         file.b(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/*     */     prof.logStart(ScriptEngine.class);
/*     */     for (Script s : this.loads) {
/*     */       try {
/*     */         s.ins.update(ds);
/*     */       } catch (Exception e) {
/*     */         error(s.load, e);
/*     */       } 
/*     */     } 
/*     */     prof.logEnd(ScriptEngine.class);
/*     */   }
/*     */   
/*     */   private static class Script {
/*     */     private final ScriptLoad load;
/*     */     private SCRIPT.SCRIPT_INSTANCE ins;
/*     */     
/*     */     Script(ScriptLoad load) {
/*     */       this.load = load;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\script\ScriptEngine.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */