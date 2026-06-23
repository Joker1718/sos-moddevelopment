/*     */ package snake2d;
/*     */ 
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.List;
/*     */ import snake2d.util.misc.ERROR_HANDLER;
/*     */ import snake2d.util.misc.OS;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CORE
/*     */ {
/*     */   public static final float UPDATE_SECONDS_MAX = 0.03125F;
/*     */   public static final float UPDATE_SECONDS_MIN = 9.765625E-4F;
/*     */   private static boolean created;
/*     */   private static GraphicContext graphics;
/*     */   private static Input input;
/*     */   private static SOUND_CORE soundCore;
/*     */   private static volatile boolean running = true;
/*     */   private static Updater updater;
/*     */   private static volatile CORE_STATE.Constructor newState;
/*     */   private static volatile Throwable updateException;
/*     */   private static volatile GlJob glJob;
/*     */   private static Thread glThread;
/*     */   private static int FPS;
/*     */   private static volatile boolean swapping = false;
/*     */   private static volatile boolean debug;
/*     */   
/*     */   public static void init(ERROR_HANDLER error) {
/*  37 */     glThread = Thread.currentThread();
/*  38 */     Errors.init(error);
/*  39 */     Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
/*     */         {
/*     */           public void uncaughtException(Thread t, Throwable e) {
/*  42 */             t.setUncaughtExceptionHandler(null);
/*  43 */             if (CORE.updateException != null) {
/*  44 */               Errors.handle(CORE.updateException);
/*  45 */               e.printStackTrace();
/*     */             } else {
/*  47 */               Errors.handle(e);
/*  48 */             }  CORE.running = false;
/*     */             try {
/*  50 */               CORE.dispose();
/*  51 */             } catch (Exception e2) {
/*  52 */               e2.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create(SETTINGS settings) {
/*  62 */     if (Thread.currentThread() != glThread) {
/*  63 */       throw new RuntimeException();
/*     */     }
/*  65 */     int mb = 1038336;
/*  66 */     String platform = String.valueOf(System.getProperty("os.name")) + ", " + System.getProperty("os.arch") + " Platform.";
/*  67 */     int nrOfPross = Runtime.getRuntime().availableProcessors();
/*  68 */     String jre = System.getProperty("java.version");
/*     */     
/*  70 */     List<String> JREargs = ManagementFactory.getRuntimeMXBean().getInputArguments();
/*  71 */     Printer.ln("SYSTEM INFO");
/*  72 */     Printer.ln("---Running on a: " + platform + " " + OS.get());
/*  73 */     String bits = System.getProperty("sun.arch.data.model");
/*  74 */     Printer.ln("---jre: " + jre + " bits: " + bits);
/*  75 */     Printer.ln("---charset: " + Charset.defaultCharset());
/*  76 */     Printer.ln("---Processors avalible: " + nrOfPross);
/*  77 */     Printer.ln("---JRE Memory");
/*     */     
/*  79 */     Runtime run = Runtime.getRuntime();
/*     */     
/*  81 */     Printer.ln("      Total: " + (run.totalMemory() / mb));
/*  82 */     Printer.ln("      Free: " + (run.freeMemory() / mb));
/*  83 */     Printer.ln("      Used: " + ((run.totalMemory() - run.freeMemory()) / mb));
/*  84 */     Printer.ln("      Max: " + (run.maxMemory() / mb));
/*  85 */     Printer.ln("---JRE Input Arguments : ", JREargs);
/*  86 */     Printer.ln("---JRE cp : ", new String[] { System.getProperty("java.class.path") });
/*     */ 
/*     */ 
/*     */     
/*  90 */     Printer.fin();
/*     */     
/*  92 */     if (created) {
/*  93 */       throw new RuntimeException("Core already created!");
/*     */     }
/*     */     
/*  96 */     created = true;
/*  97 */     swapping = false;
/*     */     
/*  99 */     graphics = new GraphicContext(settings);
/* 100 */     input = new Input(graphics, settings);
/*     */     
/* 102 */     soundCore = SOUND_CORE.create(settings);
/*     */     
/* 104 */     FPS = graphics.refreshRate;
/* 105 */     debug = settings.debugMode();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setUpdater(CORE_STATE.Constructor state) {
/* 110 */     updater = new Updater(state);
/* 111 */     updater.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
/*     */         {
/*     */           public void uncaughtException(Thread t, Throwable e) {
/* 114 */             CORE.running = false;
/* 115 */             Printer.ln("ERROR IN UPDATER DETECTED");
/* 116 */             CORE.updateException = e;
/*     */           }
/*     */         });
/* 119 */     updater.setDaemon(true);
/* 120 */     updater.start();
/*     */   }
/*     */   
/*     */   public static void performWork(Runnable r, final String name) {
/* 124 */     Thread t = new Thread(r);
/* 125 */     t.setName(name);
/* 126 */     t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
/*     */         {
/*     */           public void uncaughtException(Thread t, Throwable e) {
/* 129 */             CORE.running = false;
/* 130 */             Printer.ln("ERROR IN THREAD: " + name + "DETECTED");
/* 131 */             CORE.updateException = e;
/*     */           }
/*     */         });
/* 134 */     t.setDaemon(true);
/* 135 */     t.start();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void start(CORE_STATE.Constructor state) {
/* 140 */     running = true;
/* 141 */     swapping = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     long last = 0L;
/* 147 */     long lastSwap = System.nanoTime();
/*     */     
/* 149 */     setUpdater(state);
/* 150 */     newState = null;
/* 151 */     while (running && !swapping) {
/* 152 */       if (glJob != null) {
/* 153 */         glJob.doJob();
/* 154 */         glJob = null;
/*     */       } 
/* 156 */       if (newState != null) {
/* 157 */         dispose();
/*     */         return;
/*     */       } 
/* 160 */       sleep(1L);
/*     */     } 
/* 162 */     graphics.makeVisable();
/* 163 */     long killSwitch = System.currentTimeMillis();
/* 164 */     int kills = 0;
/* 165 */     while (running) {
/*     */       
/* 167 */       if (newState != null) {
/*     */         
/* 169 */         updater.dieHard();
/* 170 */         while (updater.isAlive()) {
/* 171 */           sleep(1L);
/*     */         }
/* 173 */         renderer().clear();
/* 174 */         soundCore.stopAllSounds();
/* 175 */         soundCore.disposeSounds();
/* 176 */         for (CORE_RESOURCE d : clientDisposables) {
/* 177 */           GlHelper.checkErrors();
/* 178 */           d.dis();
/* 179 */           GlHelper.checkErrors();
/*     */         } 
/* 181 */         clientDisposables.clear();
/*     */         
/* 183 */         input.poll(System.nanoTime(), true);
/* 184 */         input.clearAllInput();
/*     */         
/* 186 */         System.gc();
/* 187 */         GlHelper.checkErrors();
/* 188 */         setUpdater(newState);
/* 189 */         GlHelper.checkErrors();
/* 190 */         killSwitch = System.currentTimeMillis();
/* 191 */         kills = 0;
/* 192 */         newState = null;
/*     */       } 
/*     */ 
/*     */       
/* 196 */       if (glJob != null) {
/* 197 */         glJob.doJob();
/* 198 */         glJob = null;
/* 199 */         killSwitch = System.currentTimeMillis();
/* 200 */         kills = 0;
/*     */       } 
/*     */       
/* 203 */       if (swapping) {
/* 204 */         killSwitch = System.currentTimeMillis();
/* 205 */         kills = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 210 */         long nowTemp = System.nanoTime();
/*     */         
/* 212 */         long total = nowTemp;
/* 213 */         graphics.flushRenderer();
/* 214 */         CoreStats.coreFlush.set(System.nanoTime() - nowTemp);
/*     */         
/* 216 */         nowTemp = System.nanoTime();
/* 217 */         input.poll(nowTemp, graphics.isFocused());
/* 218 */         long t = System.nanoTime() - nowTemp;
/* 219 */         CoreStats.corePoll.set(t);
/*     */         
/* 221 */         swapping = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 232 */         nowTemp = System.nanoTime();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 238 */         Sleeper.sync(FPS);
/*     */         
/* 240 */         last = System.nanoTime();
/* 241 */         CoreStats.coreSleep.set(last - nowTemp);
/* 242 */         CoreStats.coreTotal.set(last - total);
/*     */         
/* 244 */         nowTemp = System.nanoTime();
/* 245 */         if (!graphics.swapAndCheckClose()) {
/* 246 */           running = false;
/*     */         }
/* 248 */         lastSwap = System.nanoTime();
/* 249 */         CoreStats.swapPercentage.set(lastSwap - nowTemp);
/*     */         continue;
/*     */       } 
/* 252 */       sleep(1L);
/* 253 */       if (System.currentTimeMillis() - killSwitch > 5000L) {
/* 254 */         kills++;
/* 255 */         if (kills > 8) {
/* 256 */           running = false;
/* 257 */           String err = "The game has taken too long to do what it's supposed to do. This can indicate that there is something wrong with the game's engine. It can also be a legit bug. Please report to the dev if your game is choppy or suffers from low FPS. info@songsofsyx.com";
/* 258 */           Printer.ln(err);
/* 259 */           StackTraceElement[] arrayOfStackTraceElement = updater.getStackTrace();
/* 260 */           for (int j = 0; j < arrayOfStackTraceElement.length; j++) {
/* 261 */             StackTraceElement s = arrayOfStackTraceElement[j];
/* 262 */             Printer.err("\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + 
/* 263 */                 s.getLineNumber() + ")");
/*     */           } 
/*     */         } 
/* 266 */         StackTraceElement[] elements = updater.getStackTrace();
/* 267 */         for (int i = 0; i < elements.length; i++) {
/* 268 */           StackTraceElement s = elements[i];
/* 269 */           Printer.ln("\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + 
/* 270 */               s.getLineNumber() + ")");
/*     */         } 
/* 272 */         Printer.ln();
/* 273 */         killSwitch = System.currentTimeMillis();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 279 */     swapping = false;
/*     */     
/* 281 */     long now = System.currentTimeMillis();
/*     */     
/* 283 */     while (updater.isAlive() && updateException == null) {
/* 284 */       swapping = false;
/* 285 */       if (System.currentTimeMillis() - now > 10000L) {
/* 286 */         Printer.err("updater refuses to die!");
/* 287 */         StackTraceElement[] elements = updater.getStackTrace();
/* 288 */         for (int i = 1; i < elements.length; i++) {
/* 289 */           StackTraceElement s = elements[i];
/* 290 */           Printer.err("\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + 
/* 291 */               s.getLineNumber() + ")");
/*     */         } 
/* 293 */         String err = "The game has taken too long to do what it's supposed to do. This can indicate that there is something wrong with the game's engine. It can also be a legit bug. Please report to the dev if your game is choppy or suffers from low FPS. info@songsofsyx.com";
/* 294 */         updateException = new RuntimeException(err);
/*     */         break;
/*     */       } 
/* 297 */       sleep(1L);
/*     */     } 
/*     */     
/* 300 */     Errors.handle(updateException);
/* 301 */     updateException = null;
/*     */     
/* 303 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void sleep(long ms) {
/*     */     try {
/* 309 */       Thread.sleep(ms);
/* 310 */     } catch (InterruptedException e) {
/* 311 */       e.printStackTrace(System.out);
/*     */     } 
/*     */   }
/*     */   
/* 315 */   private static ArrayList<CORE_RESOURCE> clientDisposables = new ArrayList(20);
/*     */   
/*     */   public static void addDisposable(CORE_RESOURCE dis) {
/* 318 */     if (Thread.currentThread() != glThread)
/* 319 */       throw new RuntimeException("gl resource must be created using a gl job :(. Threading sucks!"); 
/* 320 */     if (dis instanceof TextureHolder)
/* 321 */       getGraphics().setTexture((TextureHolder)dis); 
/* 322 */     clientDisposables.add(dis);
/*     */   }
/*     */   
/*     */   public static LIST<CORE_RESOURCE> disposables() {
/* 326 */     return (LIST<CORE_RESOURCE>)clientDisposables;
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class GlJob
/*     */   {
/*     */     private volatile boolean ru = true;
/*     */ 
/*     */     
/*     */     public final void gc() {
/* 336 */       System.gc();
/*     */     }
/*     */ 
/*     */     
/*     */     public final void perform() {
/* 341 */       final Thread t = Thread.currentThread();
/*     */       
/* 343 */       if (CORE.debug) {
/* 344 */         Thread ss = new Thread(new Runnable()
/*     */             {
/*     */               public void run()
/*     */               {
/* 348 */                 long now = System.currentTimeMillis();
/* 349 */                 while (CORE.GlJob.this.ru) {
/* 350 */                   if (System.currentTimeMillis() - now < 20000L) {
/* 351 */                     CORE.sleep(1L); continue;
/*     */                   } 
/* 353 */                   System.err.println("gl Thread is stuck!!!"); byte b; int i; StackTraceElement[] arrayOfStackTraceElement;
/* 354 */                   for (i = (arrayOfStackTraceElement = CORE.glThread.getStackTrace()).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement[b];
/* 355 */                     System.err.println(e); b++; }
/*     */                   
/* 357 */                   System.err.println(String.valueOf(t.getName()) + " is stuck!!!");
/* 358 */                   for (i = (arrayOfStackTraceElement = t.getStackTrace()).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement[b];
/* 359 */                     System.err.println(e); b++; }
/*     */                   
/* 361 */                   now = System.currentTimeMillis();
/*     */                 } 
/*     */               }
/*     */             });
/*     */         
/* 366 */         ss.setName("gljob");
/* 367 */         ss.start();
/*     */       } 
/*     */ 
/*     */       
/* 371 */       if (Thread.currentThread() == CORE.glThread && !CORE.swapping) {
/* 372 */         doJob();
/*     */       } else {
/* 374 */         CORE.glJob = this;
/* 375 */         while (CORE.glJob != null && CORE.running) {
/* 376 */           CORE.sleep(1L);
/*     */         }
/*     */       } 
/* 379 */       this.ru = false;
/*     */     }
/*     */     
/*     */     protected abstract void doJob(); }
/*     */   
/*     */   static boolean isRunning() {
/* 385 */     return running;
/*     */   }
/*     */   
/*     */   public static void annihilate(Throwable e) {
/* 389 */     updateException = e;
/* 390 */     running = false;
/* 391 */     updater.dieHard();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void annihilate() {
/* 396 */     running = false;
/* 397 */     updater.dieHard();
/*     */   }
/*     */   
/*     */   public static Input getInput() {
/* 401 */     return input;
/*     */   }
/*     */   
/*     */   public static GraphicContext getGraphics() {
/* 405 */     return graphics;
/*     */   }
/*     */   
/*     */   public static Renderer renderer() {
/* 409 */     return graphics.renderer;
/*     */   }
/*     */   
/*     */   public static SOUND_CORE getSoundCore() {
/* 413 */     return soundCore;
/*     */   }
/*     */   
/*     */   public static CoreTime getUpdateInfo() {
/* 417 */     return updater.getCoreInfo();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void swapAndPoll() {
/* 422 */     if (Thread.currentThread() == glThread && !swapping) {
/* 423 */       graphics.flushRenderer();
/* 424 */       graphics.pollEvents();
/* 425 */       running = graphics.swapAndCheckClose();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 430 */     swapping = true;
/* 431 */     while (swapping) {
/* 432 */       sleep(1L);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkIn() {
/* 438 */     (new GlJob()
/*     */       {
/*     */         protected void doJob()
/*     */         {
/* 442 */           CORE.input.poll(System.nanoTime(), CORE.graphics.isFocused());
/* 443 */           CORE.input.clearAllInput();
/*     */         }
/* 445 */       }).perform();
/*     */   }
/*     */   
/*     */   public static void setCurrentState(CORE_STATE.Constructor stateMaker) {
/* 449 */     newState = stateMaker;
/* 450 */     updater.dieHard();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void dispose() {
/* 455 */     if (!created) {
/*     */       return;
/*     */     }
/* 458 */     Printer.ln();
/* 459 */     Printer.ln("DISPOSING");
/*     */     
/* 461 */     disposeClient();
/*     */     
/* 463 */     clientDisposables.clear();
/* 464 */     if (soundCore != null) {
/* 465 */       soundCore.dis();
/* 466 */       soundCore = null;
/*     */     } 
/* 468 */     if (input != null) {
/* 469 */       input.dis();
/* 470 */       input = null;
/*     */     } 
/*     */     
/* 473 */     if (graphics != null) {
/* 474 */       GraphicContext c = graphics;
/* 475 */       graphics = null;
/* 476 */       c.dis();
/*     */     } 
/*     */     
/* 479 */     created = false;
/* 480 */     swapping = false;
/* 481 */     GraphicContext.terminate();
/* 482 */     Printer.ln("---Core was sucessfully disposed");
/* 483 */     if (GlHelper.debug) {
/* 484 */       Errors.check();
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean isGLThread() {
/* 489 */     return (glThread == Thread.currentThread());
/*     */   }
/*     */   
/*     */   public static Thread GLThread() {
/* 493 */     return glThread;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void disposeClient() {
/* 498 */     (new GlJob()
/*     */       {
/*     */         protected void doJob()
/*     */         {
/* 502 */           for (CORE_RESOURCE d : CORE.clientDisposables) {
/* 503 */             String s = GlHelper.getErrors();
/* 504 */             if (s != null) {
/* 505 */               (new RuntimeException(String.valueOf(s) + " " + d)).printStackTrace();
/*     */             }
/* 507 */             Printer.ln("---" + d);
/* 508 */             d.dis();
/* 509 */             s = GlHelper.getErrors();
/* 510 */             if (s != null) {
/* 511 */               System.err.println(s);
/* 512 */               (new RuntimeException(s)).printStackTrace();
/*     */             } 
/*     */           } 
/* 515 */           CORE.clientDisposables.clear();
/*     */         }
/* 517 */       }).perform();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\CORE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */