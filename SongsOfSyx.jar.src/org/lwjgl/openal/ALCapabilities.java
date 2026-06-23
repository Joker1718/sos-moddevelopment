/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.ThreadLocalUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ALCapabilities
/*     */ {
/*     */   public final long alGetError;
/*     */   public final long alGetErrorDirect;
/*     */   public final long alEnable;
/*     */   public final long alEnableDirect;
/*     */   public final long alDisable;
/*     */   public final long alDisableDirect;
/*     */   public final long alIsEnabled;
/*     */   public final long alIsEnabledDirect;
/*     */   public final long alGetBoolean;
/*     */   public final long alGetBooleanDirect;
/*     */   public final long alGetInteger;
/*     */   public final long alGetIntegerDirect;
/*     */   public final long alGetFloat;
/*     */   public final long alGetFloatDirect;
/*     */   public final long alGetDouble;
/*     */   public final long alGetDoubleDirect;
/*     */   public final long alGetBooleanv;
/*     */   public final long alGetBooleanvDirect;
/*     */   public final long alGetIntegerv;
/*     */   public final long alGetIntegervDirect;
/*     */   public final long alGetFloatv;
/*     */   public final long alGetFloatvDirect;
/*     */   public final long alGetDoublev;
/*     */   public final long alGetDoublevDirect;
/*     */   public final long alGetString;
/*     */   public final long alGetStringDirect;
/*     */   public final long alDistanceModel;
/*     */   public final long alDistanceModelDirect;
/*     */   public final long alDopplerFactor;
/*     */   public final long alDopplerFactorDirect;
/*     */   public final long alDopplerVelocity;
/*     */   public final long alListenerf;
/*     */   public final long alListenerfDirect;
/*     */   public final long alListeneri;
/*     */   public final long alListeneriDirect;
/*     */   public final long alListener3f;
/*     */   public final long alListener3fDirect;
/*     */   public final long alListenerfv;
/*     */   public final long alListenerfvDirect;
/*     */   public final long alGetListenerf;
/*     */   public final long alGetListenerfDirect;
/*     */   public final long alGetListeneri;
/*     */   public final long alGetListeneriDirect;
/*     */   public final long alGetListener3f;
/*     */   public final long alGetListener3fDirect;
/*     */   public final long alGetListenerfv;
/*     */   public final long alGetListenerfvDirect;
/*     */   public final long alGenSources;
/*     */   public final long alGenSourcesDirect;
/*     */   public final long alDeleteSources;
/*     */   public final long alDeleteSourcesDirect;
/*     */   public final long alIsSource;
/*     */   public final long alIsSourceDirect;
/*     */   public final long alSourcef;
/*     */   public final long alSourcefDirect;
/*     */   public final long alSource3f;
/*     */   public final long alSource3fDirect;
/*     */   public final long alSourcefv;
/*     */   public final long alSourcefvDirect;
/*     */   public final long alSourcei;
/*     */   public final long alSourceiDirect;
/*     */   public final long alGetSourcef;
/*     */   public final long alGetSourcefDirect;
/*     */   public final long alGetSource3f;
/*     */   public final long alGetSource3fDirect;
/*     */   public final long alGetSourcefv;
/*     */   public final long alGetSourcefvDirect;
/*     */   public final long alGetSourcei;
/*     */   public final long alGetSourceiDirect;
/*     */   public final long alGetSourceiv;
/*     */   public final long alGetSourceivDirect;
/*     */   public final long alSourceQueueBuffers;
/*     */   public final long alSourceQueueBuffersDirect;
/*     */   public final long alSourceUnqueueBuffers;
/*     */   public final long alSourceUnqueueBuffersDirect;
/*     */   public final long alSourcePlay;
/*     */   public final long alSourcePlayDirect;
/*     */   public final long alSourcePause;
/*     */   public final long alSourcePauseDirect;
/*     */   public final long alSourceStop;
/*     */   public final long alSourceStopDirect;
/*     */   public final long alSourceRewind;
/*     */   public final long alSourceRewindDirect;
/*     */   public final long alSourcePlayv;
/*     */   public final long alSourcePlayvDirect;
/*     */   public final long alSourcePausev;
/*     */   public final long alSourcePausevDirect;
/*     */   public final long alSourceStopv;
/*     */   public final long alSourceStopvDirect;
/*     */   public final long alSourceRewindv;
/*     */   public final long alSourceRewindvDirect;
/*     */   public final long alGenBuffers;
/*     */   public final long alGenBuffersDirect;
/*     */   public final long alDeleteBuffers;
/*     */   public final long alDeleteBuffersDirect;
/*     */   public final long alIsBuffer;
/*     */   public final long alIsBufferDirect;
/*     */   public final long alGetBufferf;
/*     */   public final long alGetBufferfDirect;
/*     */   public final long alGetBufferi;
/*     */   public final long alGetBufferiDirect;
/*     */   public final long alBufferData;
/*     */   public final long alBufferDataDirect;
/*     */   public final long alGetEnumValue;
/*     */   public final long alGetEnumValueDirect;
/*     */   public final long alGetProcAddress;
/*     */   public final long alGetProcAddressDirect;
/*     */   public final long alIsExtensionPresent;
/*     */   public final long alIsExtensionPresentDirect;
/*     */   public final long alListener3i;
/*     */   public final long alListener3iDirect;
/*     */   public final long alGetListener3i;
/*     */   public final long alGetListener3iDirect;
/*     */   public final long alGetListeneriv;
/*     */   public final long alGetListenerivDirect;
/*     */   public final long alSource3i;
/*     */   public final long alSource3iDirect;
/*     */   public final long alGetSource3i;
/*     */   public final long alGetSource3iDirect;
/*     */   public final long alListeneriv;
/*     */   public final long alListenerivDirect;
/*     */   public final long alSourceiv;
/*     */   public final long alSourceivDirect;
/*     */   public final long alBufferf;
/*     */   public final long alBufferfDirect;
/*     */   public final long alBuffer3f;
/*     */   public final long alBuffer3fDirect;
/*     */   public final long alBufferfv;
/*     */   public final long alBufferfvDirect;
/*     */   public final long alBufferi;
/*     */   public final long alBufferiDirect;
/*     */   public final long alBuffer3i;
/*     */   public final long alBuffer3iDirect;
/*     */   public final long alBufferiv;
/*     */   public final long alBufferivDirect;
/*     */   public final long alGetBuffer3i;
/*     */   public final long alGetBuffer3iDirect;
/*     */   public final long alGetBufferiv;
/*     */   public final long alGetBufferivDirect;
/*     */   public final long alGetBuffer3f;
/*     */   public final long alGetBuffer3fDirect;
/*     */   public final long alGetBufferfv;
/*     */   public final long alGetBufferfvDirect;
/*     */   public final long alSpeedOfSound;
/*     */   public final long alSpeedOfSoundDirect;
/*     */   public final long alDebugMessageCallbackEXT;
/*     */   public final long alDebugMessageCallbackDirectEXT;
/*     */   public final long alDebugMessageInsertEXT;
/*     */   public final long alDebugMessageInsertDirectEXT;
/*     */   public final long alDebugMessageControlEXT;
/*     */   public final long alDebugMessageControlDirectEXT;
/*     */   public final long alPushDebugGroupEXT;
/*     */   public final long alPushDebugGroupDirectEXT;
/*     */   public final long alPopDebugGroupEXT;
/*     */   public final long alPopDebugGroupDirectEXT;
/*     */   public final long alGetDebugMessageLogEXT;
/*     */   public final long alGetDebugMessageLogDirectEXT;
/*     */   public final long alObjectLabelEXT;
/*     */   public final long alObjectLabelDirectEXT;
/*     */   public final long alGetObjectLabelEXT;
/*     */   public final long alGetObjectLabelDirectEXT;
/*     */   public final long alGetPointerEXT;
/*     */   public final long alGetPointerDirectEXT;
/*     */   public final long alGetPointervEXT;
/*     */   public final long alGetPointervDirectEXT;
/*     */   public final long alGenEffects;
/*     */   public final long alGenEffectsDirect;
/*     */   public final long alDeleteEffects;
/*     */   public final long alDeleteEffectsDirect;
/*     */   public final long alIsEffect;
/*     */   public final long alIsEffectDirect;
/*     */   public final long alEffecti;
/*     */   public final long alEffectiDirect;
/*     */   public final long alEffectiv;
/*     */   public final long alEffectivDirect;
/*     */   public final long alEffectf;
/*     */   public final long alEffectfDirect;
/*     */   public final long alEffectfv;
/*     */   public final long alEffectfvDirect;
/*     */   public final long alGetEffecti;
/*     */   public final long alGetEffectiDirect;
/*     */   public final long alGetEffectiv;
/*     */   public final long alGetEffectivDirect;
/*     */   public final long alGetEffectf;
/*     */   public final long alGetEffectfDirect;
/*     */   public final long alGetEffectfv;
/*     */   public final long alGetEffectfvDirect;
/*     */   public final long alGenFilters;
/*     */   public final long alGenFiltersDirect;
/*     */   public final long alDeleteFilters;
/*     */   public final long alDeleteFiltersDirect;
/*     */   public final long alIsFilter;
/*     */   public final long alIsFilterDirect;
/*     */   public final long alFilteri;
/*     */   public final long alFilteriDirect;
/*     */   public final long alFilteriv;
/*     */   public final long alFilterivDirect;
/*     */   public final long alFilterf;
/*     */   public final long alFilterfDirect;
/*     */   public final long alFilterfv;
/*     */   public final long alFilterfvDirect;
/*     */   public final long alGetFilteri;
/*     */   public final long alGetFilteriDirect;
/*     */   public final long alGetFilteriv;
/*     */   public final long alGetFilterivDirect;
/*     */   public final long alGetFilterf;
/*     */   public final long alGetFilterfDirect;
/*     */   public final long alGetFilterfv;
/*     */   public final long alGetFilterfvDirect;
/*     */   public final long alGenAuxiliaryEffectSlots;
/*     */   public final long alGenAuxiliaryEffectSlotsDirect;
/*     */   public final long alDeleteAuxiliaryEffectSlots;
/*     */   public final long alDeleteAuxiliaryEffectSlotsDirect;
/*     */   public final long alIsAuxiliaryEffectSlot;
/*     */   public final long alIsAuxiliaryEffectSlotDirect;
/*     */   public final long alAuxiliaryEffectSloti;
/*     */   public final long alAuxiliaryEffectSlotiDirect;
/*     */   public final long alAuxiliaryEffectSlotiv;
/*     */   public final long alAuxiliaryEffectSlotivDirect;
/*     */   public final long alAuxiliaryEffectSlotf;
/*     */   public final long alAuxiliaryEffectSlotfDirect;
/*     */   public final long alAuxiliaryEffectSlotfv;
/*     */   public final long alAuxiliaryEffectSlotfvDirect;
/*     */   public final long alGetAuxiliaryEffectSloti;
/*     */   public final long alGetAuxiliaryEffectSlotiDirect;
/*     */   public final long alGetAuxiliaryEffectSlotiv;
/*     */   public final long alGetAuxiliaryEffectSlotivDirect;
/*     */   public final long alGetAuxiliaryEffectSlotf;
/*     */   public final long alGetAuxiliaryEffectSlotfDirect;
/*     */   public final long alGetAuxiliaryEffectSlotfv;
/*     */   public final long alGetAuxiliaryEffectSlotfvDirect;
/*     */   public final long alBufferDataStatic;
/*     */   public final long alBufferDataStaticDirect;
/*     */   public final long alBufferSamplesSOFT;
/*     */   public final long alBufferSubSamplesSOFT;
/*     */   public final long alGetBufferSamplesSOFT;
/*     */   public final long alIsBufferFormatSupportedSOFT;
/*     */   public final long alBufferSubDataSOFT;
/*     */   public final long alBufferSubDataDirectSOFT;
/*     */   public final long alBufferCallbackSOFT;
/*     */   public final long alBufferCallbackDirectSOFT;
/*     */   public final long alGetBufferPtrSOFT;
/*     */   public final long alGetBufferPtrDirectSOFT;
/*     */   public final long alGetBuffer3PtrSOFT;
/*     */   public final long alGetBuffer3PtrDirectSOFT;
/*     */   public final long alGetBufferPtrvSOFT;
/*     */   public final long alGetBufferPtrvDirectSOFT;
/*     */   public final long alDeferUpdatesSOFT;
/*     */   public final long alDeferUpdatesDirectSOFT;
/*     */   public final long alProcessUpdatesSOFT;
/*     */   public final long alProcessUpdatesDirectSOFT;
/*     */   public final long alEventControlSOFT;
/*     */   public final long alEventControlDirectSOFT;
/*     */   public final long alEventCallbackSOFT;
/*     */   public final long alEventCallbackDirectSOFT;
/*     */   public final long alGetPointerSOFT;
/*     */   public final long alGetPointerDirectSOFT;
/*     */   public final long alGetPointervSOFT;
/*     */   public final long alGetPointervDirectSOFT;
/*     */   public final long alSourcedSOFT;
/*     */   public final long alSourcedDirectSOFT;
/*     */   public final long alSource3dSOFT;
/*     */   public final long alSource3dDirectSOFT;
/*     */   public final long alSourcedvSOFT;
/*     */   public final long alSourcedvDirectSOFT;
/*     */   public final long alGetSourcedSOFT;
/*     */   public final long alGetSourcedDirectSOFT;
/*     */   public final long alGetSource3dSOFT;
/*     */   public final long alGetSource3dDirectSOFT;
/*     */   public final long alGetSourcedvSOFT;
/*     */   public final long alGetSourcedvDirectSOFT;
/*     */   public final long alSourcei64SOFT;
/*     */   public final long alSourcei64DirectSOFT;
/*     */   public final long alSource3i64SOFT;
/*     */   public final long alSource3i64DirectSOFT;
/*     */   public final long alSourcei64vSOFT;
/*     */   public final long alSourcei64vDirectSOFT;
/*     */   public final long alGetSourcei64SOFT;
/*     */   public final long alGetSourcei64DirectSOFT;
/*     */   public final long alGetSource3i64SOFT;
/*     */   public final long alGetSource3i64DirectSOFT;
/*     */   public final long alGetSourcei64vSOFT;
/*     */   public final long alGetSourcei64vDirectSOFT;
/*     */   public final long alGetStringiSOFT;
/*     */   public final long alGetStringiDirectSOFT;
/*     */   public final long alSourcePlayAtTimeSOFT;
/*     */   public final long alSourcePlayAtTimeDirectSOFT;
/*     */   public final long alSourcePlayAtTimevSOFT;
/*     */   public final long alSourcePlayAtTimevDirectSOFT;
/*     */   public final boolean OpenAL10;
/*     */   public final boolean OpenAL11;
/*     */   public final boolean AL_EXT_ALAW;
/*     */   public final boolean AL_EXT_BFORMAT;
/*     */   public final boolean AL_EXT_debug;
/*     */   public final boolean AL_EXT_direct_context;
/*     */   public final boolean AL_EXT_DOUBLE;
/*     */   public final boolean ALC_EXT_EFX;
/*     */   public final boolean AL_EXT_EXPONENT_DISTANCE;
/*     */   public final boolean AL_EXT_FLOAT32;
/*     */   public final boolean AL_EXT_IMA4;
/*     */   public final boolean AL_EXT_LINEAR_DISTANCE;
/*     */   public final boolean AL_EXT_MCFORMATS;
/*     */   public final boolean AL_EXT_MULAW;
/*     */   public final boolean AL_EXT_MULAW_BFORMAT;
/*     */   public final boolean AL_EXT_MULAW_MCFORMATS;
/*     */   public final boolean AL_EXT_OFFSET;
/*     */   public final boolean AL_EXT_source_distance_model;
/*     */   public final boolean AL_EXT_SOURCE_RADIUS;
/*     */   public final boolean AL_EXT_STATIC_BUFFER;
/*     */   public final boolean AL_EXT_STEREO_ANGLES;
/*     */   public final boolean AL_EXT_vorbis;
/*     */   public final boolean AL_LOKI_IMA_ADPCM;
/*     */   public final boolean AL_LOKI_quadriphonic;
/*     */   public final boolean AL_LOKI_WAVE_format;
/*     */   public final boolean AL_SOFT_bformat_ex;
/*     */   public final boolean AL_SOFT_bformat_hoa;
/*     */   public final boolean AL_SOFT_block_alignment;
/*     */   public final boolean AL_SOFT_buffer_length_query;
/*     */   public final boolean AL_SOFT_buffer_samples;
/*     */   public final boolean AL_SOFT_buffer_sub_data;
/*     */   public final boolean AL_SOFT_callback_buffer;
/*     */   public final boolean AL_SOFT_deferred_updates;
/*     */   public final boolean AL_SOFT_direct_channels;
/*     */   public final boolean AL_SOFT_direct_channels_remix;
/*     */   public final boolean AL_SOFT_effect_target;
/*     */   public final boolean AL_SOFT_events;
/*     */   public final boolean AL_SOFT_gain_clamp_ex;
/*     */   public final boolean AL_SOFT_loop_points;
/*     */   public final boolean AL_SOFT_MSADPCM;
/*     */   public final boolean AL_SOFT_source_latency;
/*     */   public final boolean AL_SOFT_source_length;
/*     */   public final boolean AL_SOFT_source_resampler;
/*     */   public final boolean AL_SOFT_source_spatialize;
/*     */   public final boolean AL_SOFT_source_start_delay;
/*     */   public final boolean AL_SOFT_UHJ;
/*     */   public final boolean AL_SOFT_UHJ_ex;
/*     */   public final boolean AL_SOFTX_hold_on_disconnect;
/*     */   final PointerBuffer addresses;
/*     */   
/*     */   ALCapabilities(FunctionProvider provider, Set<String> ext, IntFunction<PointerBuffer> bufferFactory) {
/* 447 */     PointerBuffer caps = bufferFactory.apply(289);
/*     */     
/* 449 */     this.OpenAL10 = check_AL10(provider, caps, ext);
/* 450 */     this.OpenAL11 = check_AL11(provider, caps, ext);
/* 451 */     this.AL_EXT_ALAW = ext.contains("AL_EXT_ALAW");
/* 452 */     this.AL_EXT_BFORMAT = ext.contains("AL_EXT_BFORMAT");
/* 453 */     this.AL_EXT_debug = check_EXT_debug(provider, caps, ext);
/* 454 */     this.AL_EXT_direct_context = ext.contains("AL_EXT_direct_context");
/* 455 */     this.AL_EXT_DOUBLE = ext.contains("AL_EXT_DOUBLE");
/* 456 */     this.ALC_EXT_EFX = check_EXT_EFX(provider, caps, ext);
/* 457 */     this.AL_EXT_EXPONENT_DISTANCE = ext.contains("AL_EXT_EXPONENT_DISTANCE");
/* 458 */     this.AL_EXT_FLOAT32 = ext.contains("AL_EXT_FLOAT32");
/* 459 */     this.AL_EXT_IMA4 = ext.contains("AL_EXT_IMA4");
/* 460 */     this.AL_EXT_LINEAR_DISTANCE = ext.contains("AL_EXT_LINEAR_DISTANCE");
/* 461 */     this.AL_EXT_MCFORMATS = ext.contains("AL_EXT_MCFORMATS");
/* 462 */     this.AL_EXT_MULAW = ext.contains("AL_EXT_MULAW");
/* 463 */     this.AL_EXT_MULAW_BFORMAT = ext.contains("AL_EXT_MULAW_BFORMAT");
/* 464 */     this.AL_EXT_MULAW_MCFORMATS = ext.contains("AL_EXT_MULAW_MCFORMATS");
/* 465 */     this.AL_EXT_OFFSET = ext.contains("AL_EXT_OFFSET");
/* 466 */     this.AL_EXT_source_distance_model = ext.contains("AL_EXT_source_distance_model");
/* 467 */     this.AL_EXT_SOURCE_RADIUS = ext.contains("AL_EXT_SOURCE_RADIUS");
/* 468 */     this.AL_EXT_STATIC_BUFFER = check_EXT_STATIC_BUFFER(provider, caps, ext);
/* 469 */     this.AL_EXT_STEREO_ANGLES = ext.contains("AL_EXT_STEREO_ANGLES");
/* 470 */     this.AL_EXT_vorbis = ext.contains("AL_EXT_vorbis");
/* 471 */     this.AL_LOKI_IMA_ADPCM = ext.contains("AL_LOKI_IMA_ADPCM");
/* 472 */     this.AL_LOKI_quadriphonic = ext.contains("AL_LOKI_quadriphonic");
/* 473 */     this.AL_LOKI_WAVE_format = ext.contains("AL_LOKI_WAVE_format");
/* 474 */     this.AL_SOFT_bformat_ex = ext.contains("AL_SOFT_bformat_ex");
/* 475 */     this.AL_SOFT_bformat_hoa = ext.contains("AL_SOFT_bformat_hoa");
/* 476 */     this.AL_SOFT_block_alignment = ext.contains("AL_SOFT_block_alignment");
/* 477 */     this.AL_SOFT_buffer_length_query = ext.contains("AL_SOFT_buffer_length_query");
/* 478 */     this.AL_SOFT_buffer_samples = check_SOFT_buffer_samples(provider, caps, ext);
/* 479 */     this.AL_SOFT_buffer_sub_data = check_SOFT_buffer_sub_data(provider, caps, ext);
/* 480 */     this.AL_SOFT_callback_buffer = check_SOFT_callback_buffer(provider, caps, ext);
/* 481 */     this.AL_SOFT_deferred_updates = check_SOFT_deferred_updates(provider, caps, ext);
/* 482 */     this.AL_SOFT_direct_channels = ext.contains("AL_SOFT_direct_channels");
/* 483 */     this.AL_SOFT_direct_channels_remix = ext.contains("AL_SOFT_direct_channels_remix");
/* 484 */     this.AL_SOFT_effect_target = ext.contains("AL_SOFT_effect_target");
/* 485 */     this.AL_SOFT_events = check_SOFT_events(provider, caps, ext);
/* 486 */     this.AL_SOFT_gain_clamp_ex = ext.contains("AL_SOFT_gain_clamp_ex");
/* 487 */     this.AL_SOFT_loop_points = ext.contains("AL_SOFT_loop_points");
/* 488 */     this.AL_SOFT_MSADPCM = ext.contains("AL_SOFT_MSADPCM");
/* 489 */     this.AL_SOFT_source_latency = check_SOFT_source_latency(provider, caps, ext);
/* 490 */     this.AL_SOFT_source_length = ext.contains("AL_SOFT_source_length");
/* 491 */     this.AL_SOFT_source_resampler = check_SOFT_source_resampler(provider, caps, ext);
/* 492 */     this.AL_SOFT_source_spatialize = ext.contains("AL_SOFT_source_spatialize");
/* 493 */     this.AL_SOFT_source_start_delay = check_SOFT_source_start_delay(provider, caps, ext);
/* 494 */     this.AL_SOFT_UHJ = ext.contains("AL_SOFT_UHJ");
/* 495 */     this.AL_SOFT_UHJ_ex = ext.contains("AL_SOFT_UHJ_ex");
/* 496 */     this.AL_SOFTX_hold_on_disconnect = ext.contains("AL_SOFTX_hold_on_disconnect");
/*     */     
/* 498 */     this.alGetError = caps.get(0);
/* 499 */     this.alGetErrorDirect = caps.get(1);
/* 500 */     this.alEnable = caps.get(2);
/* 501 */     this.alEnableDirect = caps.get(3);
/* 502 */     this.alDisable = caps.get(4);
/* 503 */     this.alDisableDirect = caps.get(5);
/* 504 */     this.alIsEnabled = caps.get(6);
/* 505 */     this.alIsEnabledDirect = caps.get(7);
/* 506 */     this.alGetBoolean = caps.get(8);
/* 507 */     this.alGetBooleanDirect = caps.get(9);
/* 508 */     this.alGetInteger = caps.get(10);
/* 509 */     this.alGetIntegerDirect = caps.get(11);
/* 510 */     this.alGetFloat = caps.get(12);
/* 511 */     this.alGetFloatDirect = caps.get(13);
/* 512 */     this.alGetDouble = caps.get(14);
/* 513 */     this.alGetDoubleDirect = caps.get(15);
/* 514 */     this.alGetBooleanv = caps.get(16);
/* 515 */     this.alGetBooleanvDirect = caps.get(17);
/* 516 */     this.alGetIntegerv = caps.get(18);
/* 517 */     this.alGetIntegervDirect = caps.get(19);
/* 518 */     this.alGetFloatv = caps.get(20);
/* 519 */     this.alGetFloatvDirect = caps.get(21);
/* 520 */     this.alGetDoublev = caps.get(22);
/* 521 */     this.alGetDoublevDirect = caps.get(23);
/* 522 */     this.alGetString = caps.get(24);
/* 523 */     this.alGetStringDirect = caps.get(25);
/* 524 */     this.alDistanceModel = caps.get(26);
/* 525 */     this.alDistanceModelDirect = caps.get(27);
/* 526 */     this.alDopplerFactor = caps.get(28);
/* 527 */     this.alDopplerFactorDirect = caps.get(29);
/* 528 */     this.alDopplerVelocity = caps.get(30);
/* 529 */     this.alListenerf = caps.get(31);
/* 530 */     this.alListenerfDirect = caps.get(32);
/* 531 */     this.alListeneri = caps.get(33);
/* 532 */     this.alListeneriDirect = caps.get(34);
/* 533 */     this.alListener3f = caps.get(35);
/* 534 */     this.alListener3fDirect = caps.get(36);
/* 535 */     this.alListenerfv = caps.get(37);
/* 536 */     this.alListenerfvDirect = caps.get(38);
/* 537 */     this.alGetListenerf = caps.get(39);
/* 538 */     this.alGetListenerfDirect = caps.get(40);
/* 539 */     this.alGetListeneri = caps.get(41);
/* 540 */     this.alGetListeneriDirect = caps.get(42);
/* 541 */     this.alGetListener3f = caps.get(43);
/* 542 */     this.alGetListener3fDirect = caps.get(44);
/* 543 */     this.alGetListenerfv = caps.get(45);
/* 544 */     this.alGetListenerfvDirect = caps.get(46);
/* 545 */     this.alGenSources = caps.get(47);
/* 546 */     this.alGenSourcesDirect = caps.get(48);
/* 547 */     this.alDeleteSources = caps.get(49);
/* 548 */     this.alDeleteSourcesDirect = caps.get(50);
/* 549 */     this.alIsSource = caps.get(51);
/* 550 */     this.alIsSourceDirect = caps.get(52);
/* 551 */     this.alSourcef = caps.get(53);
/* 552 */     this.alSourcefDirect = caps.get(54);
/* 553 */     this.alSource3f = caps.get(55);
/* 554 */     this.alSource3fDirect = caps.get(56);
/* 555 */     this.alSourcefv = caps.get(57);
/* 556 */     this.alSourcefvDirect = caps.get(58);
/* 557 */     this.alSourcei = caps.get(59);
/* 558 */     this.alSourceiDirect = caps.get(60);
/* 559 */     this.alGetSourcef = caps.get(61);
/* 560 */     this.alGetSourcefDirect = caps.get(62);
/* 561 */     this.alGetSource3f = caps.get(63);
/* 562 */     this.alGetSource3fDirect = caps.get(64);
/* 563 */     this.alGetSourcefv = caps.get(65);
/* 564 */     this.alGetSourcefvDirect = caps.get(66);
/* 565 */     this.alGetSourcei = caps.get(67);
/* 566 */     this.alGetSourceiDirect = caps.get(68);
/* 567 */     this.alGetSourceiv = caps.get(69);
/* 568 */     this.alGetSourceivDirect = caps.get(70);
/* 569 */     this.alSourceQueueBuffers = caps.get(71);
/* 570 */     this.alSourceQueueBuffersDirect = caps.get(72);
/* 571 */     this.alSourceUnqueueBuffers = caps.get(73);
/* 572 */     this.alSourceUnqueueBuffersDirect = caps.get(74);
/* 573 */     this.alSourcePlay = caps.get(75);
/* 574 */     this.alSourcePlayDirect = caps.get(76);
/* 575 */     this.alSourcePause = caps.get(77);
/* 576 */     this.alSourcePauseDirect = caps.get(78);
/* 577 */     this.alSourceStop = caps.get(79);
/* 578 */     this.alSourceStopDirect = caps.get(80);
/* 579 */     this.alSourceRewind = caps.get(81);
/* 580 */     this.alSourceRewindDirect = caps.get(82);
/* 581 */     this.alSourcePlayv = caps.get(83);
/* 582 */     this.alSourcePlayvDirect = caps.get(84);
/* 583 */     this.alSourcePausev = caps.get(85);
/* 584 */     this.alSourcePausevDirect = caps.get(86);
/* 585 */     this.alSourceStopv = caps.get(87);
/* 586 */     this.alSourceStopvDirect = caps.get(88);
/* 587 */     this.alSourceRewindv = caps.get(89);
/* 588 */     this.alSourceRewindvDirect = caps.get(90);
/* 589 */     this.alGenBuffers = caps.get(91);
/* 590 */     this.alGenBuffersDirect = caps.get(92);
/* 591 */     this.alDeleteBuffers = caps.get(93);
/* 592 */     this.alDeleteBuffersDirect = caps.get(94);
/* 593 */     this.alIsBuffer = caps.get(95);
/* 594 */     this.alIsBufferDirect = caps.get(96);
/* 595 */     this.alGetBufferf = caps.get(97);
/* 596 */     this.alGetBufferfDirect = caps.get(98);
/* 597 */     this.alGetBufferi = caps.get(99);
/* 598 */     this.alGetBufferiDirect = caps.get(100);
/* 599 */     this.alBufferData = caps.get(101);
/* 600 */     this.alBufferDataDirect = caps.get(102);
/* 601 */     this.alGetEnumValue = caps.get(103);
/* 602 */     this.alGetEnumValueDirect = caps.get(104);
/* 603 */     this.alGetProcAddress = caps.get(105);
/* 604 */     this.alGetProcAddressDirect = caps.get(106);
/* 605 */     this.alIsExtensionPresent = caps.get(107);
/* 606 */     this.alIsExtensionPresentDirect = caps.get(108);
/* 607 */     this.alListener3i = caps.get(109);
/* 608 */     this.alListener3iDirect = caps.get(110);
/* 609 */     this.alGetListener3i = caps.get(111);
/* 610 */     this.alGetListener3iDirect = caps.get(112);
/* 611 */     this.alGetListeneriv = caps.get(113);
/* 612 */     this.alGetListenerivDirect = caps.get(114);
/* 613 */     this.alSource3i = caps.get(115);
/* 614 */     this.alSource3iDirect = caps.get(116);
/* 615 */     this.alGetSource3i = caps.get(117);
/* 616 */     this.alGetSource3iDirect = caps.get(118);
/* 617 */     this.alListeneriv = caps.get(119);
/* 618 */     this.alListenerivDirect = caps.get(120);
/* 619 */     this.alSourceiv = caps.get(121);
/* 620 */     this.alSourceivDirect = caps.get(122);
/* 621 */     this.alBufferf = caps.get(123);
/* 622 */     this.alBufferfDirect = caps.get(124);
/* 623 */     this.alBuffer3f = caps.get(125);
/* 624 */     this.alBuffer3fDirect = caps.get(126);
/* 625 */     this.alBufferfv = caps.get(127);
/* 626 */     this.alBufferfvDirect = caps.get(128);
/* 627 */     this.alBufferi = caps.get(129);
/* 628 */     this.alBufferiDirect = caps.get(130);
/* 629 */     this.alBuffer3i = caps.get(131);
/* 630 */     this.alBuffer3iDirect = caps.get(132);
/* 631 */     this.alBufferiv = caps.get(133);
/* 632 */     this.alBufferivDirect = caps.get(134);
/* 633 */     this.alGetBuffer3i = caps.get(135);
/* 634 */     this.alGetBuffer3iDirect = caps.get(136);
/* 635 */     this.alGetBufferiv = caps.get(137);
/* 636 */     this.alGetBufferivDirect = caps.get(138);
/* 637 */     this.alGetBuffer3f = caps.get(139);
/* 638 */     this.alGetBuffer3fDirect = caps.get(140);
/* 639 */     this.alGetBufferfv = caps.get(141);
/* 640 */     this.alGetBufferfvDirect = caps.get(142);
/* 641 */     this.alSpeedOfSound = caps.get(143);
/* 642 */     this.alSpeedOfSoundDirect = caps.get(144);
/* 643 */     this.alDebugMessageCallbackEXT = caps.get(145);
/* 644 */     this.alDebugMessageCallbackDirectEXT = caps.get(146);
/* 645 */     this.alDebugMessageInsertEXT = caps.get(147);
/* 646 */     this.alDebugMessageInsertDirectEXT = caps.get(148);
/* 647 */     this.alDebugMessageControlEXT = caps.get(149);
/* 648 */     this.alDebugMessageControlDirectEXT = caps.get(150);
/* 649 */     this.alPushDebugGroupEXT = caps.get(151);
/* 650 */     this.alPushDebugGroupDirectEXT = caps.get(152);
/* 651 */     this.alPopDebugGroupEXT = caps.get(153);
/* 652 */     this.alPopDebugGroupDirectEXT = caps.get(154);
/* 653 */     this.alGetDebugMessageLogEXT = caps.get(155);
/* 654 */     this.alGetDebugMessageLogDirectEXT = caps.get(156);
/* 655 */     this.alObjectLabelEXT = caps.get(157);
/* 656 */     this.alObjectLabelDirectEXT = caps.get(158);
/* 657 */     this.alGetObjectLabelEXT = caps.get(159);
/* 658 */     this.alGetObjectLabelDirectEXT = caps.get(160);
/* 659 */     this.alGetPointerEXT = caps.get(161);
/* 660 */     this.alGetPointerDirectEXT = caps.get(162);
/* 661 */     this.alGetPointervEXT = caps.get(163);
/* 662 */     this.alGetPointervDirectEXT = caps.get(164);
/* 663 */     this.alGenEffects = caps.get(165);
/* 664 */     this.alGenEffectsDirect = caps.get(166);
/* 665 */     this.alDeleteEffects = caps.get(167);
/* 666 */     this.alDeleteEffectsDirect = caps.get(168);
/* 667 */     this.alIsEffect = caps.get(169);
/* 668 */     this.alIsEffectDirect = caps.get(170);
/* 669 */     this.alEffecti = caps.get(171);
/* 670 */     this.alEffectiDirect = caps.get(172);
/* 671 */     this.alEffectiv = caps.get(173);
/* 672 */     this.alEffectivDirect = caps.get(174);
/* 673 */     this.alEffectf = caps.get(175);
/* 674 */     this.alEffectfDirect = caps.get(176);
/* 675 */     this.alEffectfv = caps.get(177);
/* 676 */     this.alEffectfvDirect = caps.get(178);
/* 677 */     this.alGetEffecti = caps.get(179);
/* 678 */     this.alGetEffectiDirect = caps.get(180);
/* 679 */     this.alGetEffectiv = caps.get(181);
/* 680 */     this.alGetEffectivDirect = caps.get(182);
/* 681 */     this.alGetEffectf = caps.get(183);
/* 682 */     this.alGetEffectfDirect = caps.get(184);
/* 683 */     this.alGetEffectfv = caps.get(185);
/* 684 */     this.alGetEffectfvDirect = caps.get(186);
/* 685 */     this.alGenFilters = caps.get(187);
/* 686 */     this.alGenFiltersDirect = caps.get(188);
/* 687 */     this.alDeleteFilters = caps.get(189);
/* 688 */     this.alDeleteFiltersDirect = caps.get(190);
/* 689 */     this.alIsFilter = caps.get(191);
/* 690 */     this.alIsFilterDirect = caps.get(192);
/* 691 */     this.alFilteri = caps.get(193);
/* 692 */     this.alFilteriDirect = caps.get(194);
/* 693 */     this.alFilteriv = caps.get(195);
/* 694 */     this.alFilterivDirect = caps.get(196);
/* 695 */     this.alFilterf = caps.get(197);
/* 696 */     this.alFilterfDirect = caps.get(198);
/* 697 */     this.alFilterfv = caps.get(199);
/* 698 */     this.alFilterfvDirect = caps.get(200);
/* 699 */     this.alGetFilteri = caps.get(201);
/* 700 */     this.alGetFilteriDirect = caps.get(202);
/* 701 */     this.alGetFilteriv = caps.get(203);
/* 702 */     this.alGetFilterivDirect = caps.get(204);
/* 703 */     this.alGetFilterf = caps.get(205);
/* 704 */     this.alGetFilterfDirect = caps.get(206);
/* 705 */     this.alGetFilterfv = caps.get(207);
/* 706 */     this.alGetFilterfvDirect = caps.get(208);
/* 707 */     this.alGenAuxiliaryEffectSlots = caps.get(209);
/* 708 */     this.alGenAuxiliaryEffectSlotsDirect = caps.get(210);
/* 709 */     this.alDeleteAuxiliaryEffectSlots = caps.get(211);
/* 710 */     this.alDeleteAuxiliaryEffectSlotsDirect = caps.get(212);
/* 711 */     this.alIsAuxiliaryEffectSlot = caps.get(213);
/* 712 */     this.alIsAuxiliaryEffectSlotDirect = caps.get(214);
/* 713 */     this.alAuxiliaryEffectSloti = caps.get(215);
/* 714 */     this.alAuxiliaryEffectSlotiDirect = caps.get(216);
/* 715 */     this.alAuxiliaryEffectSlotiv = caps.get(217);
/* 716 */     this.alAuxiliaryEffectSlotivDirect = caps.get(218);
/* 717 */     this.alAuxiliaryEffectSlotf = caps.get(219);
/* 718 */     this.alAuxiliaryEffectSlotfDirect = caps.get(220);
/* 719 */     this.alAuxiliaryEffectSlotfv = caps.get(221);
/* 720 */     this.alAuxiliaryEffectSlotfvDirect = caps.get(222);
/* 721 */     this.alGetAuxiliaryEffectSloti = caps.get(223);
/* 722 */     this.alGetAuxiliaryEffectSlotiDirect = caps.get(224);
/* 723 */     this.alGetAuxiliaryEffectSlotiv = caps.get(225);
/* 724 */     this.alGetAuxiliaryEffectSlotivDirect = caps.get(226);
/* 725 */     this.alGetAuxiliaryEffectSlotf = caps.get(227);
/* 726 */     this.alGetAuxiliaryEffectSlotfDirect = caps.get(228);
/* 727 */     this.alGetAuxiliaryEffectSlotfv = caps.get(229);
/* 728 */     this.alGetAuxiliaryEffectSlotfvDirect = caps.get(230);
/* 729 */     this.alBufferDataStatic = caps.get(231);
/* 730 */     this.alBufferDataStaticDirect = caps.get(232);
/* 731 */     this.alBufferSamplesSOFT = caps.get(233);
/* 732 */     this.alBufferSubSamplesSOFT = caps.get(234);
/* 733 */     this.alGetBufferSamplesSOFT = caps.get(235);
/* 734 */     this.alIsBufferFormatSupportedSOFT = caps.get(236);
/* 735 */     this.alBufferSubDataSOFT = caps.get(237);
/* 736 */     this.alBufferSubDataDirectSOFT = caps.get(238);
/* 737 */     this.alBufferCallbackSOFT = caps.get(239);
/* 738 */     this.alBufferCallbackDirectSOFT = caps.get(240);
/* 739 */     this.alGetBufferPtrSOFT = caps.get(241);
/* 740 */     this.alGetBufferPtrDirectSOFT = caps.get(242);
/* 741 */     this.alGetBuffer3PtrSOFT = caps.get(243);
/* 742 */     this.alGetBuffer3PtrDirectSOFT = caps.get(244);
/* 743 */     this.alGetBufferPtrvSOFT = caps.get(245);
/* 744 */     this.alGetBufferPtrvDirectSOFT = caps.get(246);
/* 745 */     this.alDeferUpdatesSOFT = caps.get(247);
/* 746 */     this.alDeferUpdatesDirectSOFT = caps.get(248);
/* 747 */     this.alProcessUpdatesSOFT = caps.get(249);
/* 748 */     this.alProcessUpdatesDirectSOFT = caps.get(250);
/* 749 */     this.alEventControlSOFT = caps.get(251);
/* 750 */     this.alEventControlDirectSOFT = caps.get(252);
/* 751 */     this.alEventCallbackSOFT = caps.get(253);
/* 752 */     this.alEventCallbackDirectSOFT = caps.get(254);
/* 753 */     this.alGetPointerSOFT = caps.get(255);
/* 754 */     this.alGetPointerDirectSOFT = caps.get(256);
/* 755 */     this.alGetPointervSOFT = caps.get(257);
/* 756 */     this.alGetPointervDirectSOFT = caps.get(258);
/* 757 */     this.alSourcedSOFT = caps.get(259);
/* 758 */     this.alSourcedDirectSOFT = caps.get(260);
/* 759 */     this.alSource3dSOFT = caps.get(261);
/* 760 */     this.alSource3dDirectSOFT = caps.get(262);
/* 761 */     this.alSourcedvSOFT = caps.get(263);
/* 762 */     this.alSourcedvDirectSOFT = caps.get(264);
/* 763 */     this.alGetSourcedSOFT = caps.get(265);
/* 764 */     this.alGetSourcedDirectSOFT = caps.get(266);
/* 765 */     this.alGetSource3dSOFT = caps.get(267);
/* 766 */     this.alGetSource3dDirectSOFT = caps.get(268);
/* 767 */     this.alGetSourcedvSOFT = caps.get(269);
/* 768 */     this.alGetSourcedvDirectSOFT = caps.get(270);
/* 769 */     this.alSourcei64SOFT = caps.get(271);
/* 770 */     this.alSourcei64DirectSOFT = caps.get(272);
/* 771 */     this.alSource3i64SOFT = caps.get(273);
/* 772 */     this.alSource3i64DirectSOFT = caps.get(274);
/* 773 */     this.alSourcei64vSOFT = caps.get(275);
/* 774 */     this.alSourcei64vDirectSOFT = caps.get(276);
/* 775 */     this.alGetSourcei64SOFT = caps.get(277);
/* 776 */     this.alGetSourcei64DirectSOFT = caps.get(278);
/* 777 */     this.alGetSource3i64SOFT = caps.get(279);
/* 778 */     this.alGetSource3i64DirectSOFT = caps.get(280);
/* 779 */     this.alGetSourcei64vSOFT = caps.get(281);
/* 780 */     this.alGetSourcei64vDirectSOFT = caps.get(282);
/* 781 */     this.alGetStringiSOFT = caps.get(283);
/* 782 */     this.alGetStringiDirectSOFT = caps.get(284);
/* 783 */     this.alSourcePlayAtTimeSOFT = caps.get(285);
/* 784 */     this.alSourcePlayAtTimeDirectSOFT = caps.get(286);
/* 785 */     this.alSourcePlayAtTimevSOFT = caps.get(287);
/* 786 */     this.alSourcePlayAtTimevDirectSOFT = caps.get(288);
/*     */     
/* 788 */     this.addresses = ThreadLocalUtil.setupAddressBuffer(caps);
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer getAddressBuffer() {
/* 793 */     return this.addresses;
/*     */   }
/*     */   
/*     */   private static boolean check_AL10(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 797 */     if (!ext.contains("OpenAL10")) {
/* 798 */       return false;
/*     */     }
/*     */     
/* 801 */     return (Checks.checkFunctions(provider, caps, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108 }, new String[] { "alGetError", "alGetErrorDirect", "alEnable", "alEnableDirect", "alDisable", "alDisableDirect", "alIsEnabled", "alIsEnabledDirect", "alGetBoolean", "alGetBooleanDirect", "alGetInteger", "alGetIntegerDirect", "alGetFloat", "alGetFloatDirect", "alGetDouble", "alGetDoubleDirect", "alGetBooleanv", "alGetBooleanvDirect", "alGetIntegerv", "alGetIntegervDirect", "alGetFloatv", "alGetFloatvDirect", "alGetDoublev", "alGetDoublevDirect", "alGetString", "alGetStringDirect", "alDistanceModel", "alDistanceModelDirect", "alDopplerFactor", "alDopplerFactorDirect", "alDopplerVelocity", "alListenerf", "alListenerfDirect", "alListeneri", "alListeneriDirect", "alListener3f", "alListener3fDirect", "alListenerfv", "alListenerfvDirect", "alGetListenerf", "alGetListenerfDirect", "alGetListeneri", "alGetListeneriDirect", "alGetListener3f", "alGetListener3fDirect", "alGetListenerfv", "alGetListenerfvDirect", "alGenSources", "alGenSourcesDirect", "alDeleteSources", "alDeleteSourcesDirect", "alIsSource", "alIsSourceDirect", "alSourcef", "alSourcefDirect", "alSource3f", "alSource3fDirect", "alSourcefv", "alSourcefvDirect", "alSourcei", "alSourceiDirect", "alGetSourcef", "alGetSourcefDirect", "alGetSource3f", "alGetSource3fDirect", "alGetSourcefv", "alGetSourcefvDirect", "alGetSourcei", "alGetSourceiDirect", "alGetSourceiv", "alGetSourceivDirect", "alSourceQueueBuffers", "alSourceQueueBuffersDirect", "alSourceUnqueueBuffers", "alSourceUnqueueBuffersDirect", "alSourcePlay", "alSourcePlayDirect", "alSourcePause", "alSourcePauseDirect", "alSourceStop", "alSourceStopDirect", "alSourceRewind", "alSourceRewindDirect", "alSourcePlayv", "alSourcePlayvDirect", "alSourcePausev", "alSourcePausevDirect", "alSourceStopv", "alSourceStopvDirect", "alSourceRewindv", "alSourceRewindvDirect", "alGenBuffers", "alGenBuffersDirect", "alDeleteBuffers", "alDeleteBuffersDirect", "alIsBuffer", "alIsBufferDirect", "alGetBufferf", "alGetBufferfDirect", "alGetBufferi", "alGetBufferiDirect", "alBufferData", "alBufferDataDirect", "alGetEnumValue", "alGetEnumValueDirect", "alGetProcAddress", "alGetProcAddressDirect", "alIsExtensionPresent", "alIsExtensionPresentDirect"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 821 */         }) || Checks.reportMissing("AL", "OpenAL10"));
/*     */   }
/*     */   
/*     */   private static boolean check_AL11(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 825 */     if (!ext.contains("OpenAL11")) {
/* 826 */       return false;
/*     */     }
/*     */     
/* 829 */     return (Checks.checkFunctions(provider, caps, new int[] { 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144 }, new String[] { "alListener3i", "alListener3iDirect", "alGetListener3i", "alGetListener3iDirect", "alGetListeneriv", "alGetListenerivDirect", "alSource3i", "alSource3iDirect", "alGetSource3i", "alGetSource3iDirect", "alListeneriv", "alListenerivDirect", "alSourceiv", "alSourceivDirect", "alBufferf", "alBufferfDirect", "alBuffer3f", "alBuffer3fDirect", "alBufferfv", "alBufferfvDirect", "alBufferi", "alBufferiDirect", "alBuffer3i", "alBuffer3iDirect", "alBufferiv", "alBufferivDirect", "alGetBuffer3i", "alGetBuffer3iDirect", "alGetBufferiv", "alGetBufferivDirect", "alGetBuffer3f", "alGetBuffer3fDirect", "alGetBufferfv", "alGetBufferfvDirect", "alSpeedOfSound", "alSpeedOfSoundDirect"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 838 */         }) || Checks.reportMissing("AL", "OpenAL11"));
/*     */   }
/*     */   
/*     */   private static boolean check_EXT_debug(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 842 */     if (!ext.contains("AL_EXT_debug")) {
/* 843 */       return false;
/*     */     }
/*     */     
/* 846 */     return (Checks.checkFunctions(provider, caps, new int[] { 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164 }, new String[] { "alDebugMessageCallbackEXT", "alDebugMessageCallbackDirectEXT", "alDebugMessageInsertEXT", "alDebugMessageInsertDirectEXT", "alDebugMessageControlEXT", "alDebugMessageControlDirectEXT", "alPushDebugGroupEXT", "alPushDebugGroupDirectEXT", "alPopDebugGroupEXT", "alPopDebugGroupDirectEXT", "alGetDebugMessageLogEXT", "alGetDebugMessageLogDirectEXT", "alObjectLabelEXT", "alObjectLabelDirectEXT", "alGetObjectLabelEXT", "alGetObjectLabelDirectEXT", "alGetPointerEXT", "alGetPointerDirectEXT", "alGetPointervEXT", "alGetPointervDirectEXT"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 853 */         }) || Checks.reportMissing("AL", "AL_EXT_debug"));
/*     */   }
/*     */   
/*     */   private static boolean check_EXT_EFX(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 857 */     if (!ext.contains("ALC_EXT_EFX")) {
/* 858 */       return false;
/*     */     }
/*     */     
/* 861 */     return (Checks.checkFunctions(provider, caps, new int[] { 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230 }, new String[] { "alGenEffects", "alGenEffectsDirect", "alDeleteEffects", "alDeleteEffectsDirect", "alIsEffect", "alIsEffectDirect", "alEffecti", "alEffectiDirect", "alEffectiv", "alEffectivDirect", "alEffectf", "alEffectfDirect", "alEffectfv", "alEffectfvDirect", "alGetEffecti", "alGetEffectiDirect", "alGetEffectiv", "alGetEffectivDirect", "alGetEffectf", "alGetEffectfDirect", "alGetEffectfv", "alGetEffectfvDirect", "alGenFilters", "alGenFiltersDirect", "alDeleteFilters", "alDeleteFiltersDirect", "alIsFilter", "alIsFilterDirect", "alFilteri", "alFilteriDirect", "alFilteriv", "alFilterivDirect", "alFilterf", "alFilterfDirect", "alFilterfv", "alFilterfvDirect", "alGetFilteri", "alGetFilteriDirect", "alGetFilteriv", "alGetFilterivDirect", "alGetFilterf", "alGetFilterfDirect", "alGetFilterfv", "alGetFilterfvDirect", "alGenAuxiliaryEffectSlots", "alGenAuxiliaryEffectSlotsDirect", "alDeleteAuxiliaryEffectSlots", "alDeleteAuxiliaryEffectSlotsDirect", "alIsAuxiliaryEffectSlot", "alIsAuxiliaryEffectSlotDirect", "alAuxiliaryEffectSloti", "alAuxiliaryEffectSlotiDirect", "alAuxiliaryEffectSlotiv", "alAuxiliaryEffectSlotivDirect", "alAuxiliaryEffectSlotf", "alAuxiliaryEffectSlotfDirect", "alAuxiliaryEffectSlotfv", "alAuxiliaryEffectSlotfvDirect", "alGetAuxiliaryEffectSloti", "alGetAuxiliaryEffectSlotiDirect", "alGetAuxiliaryEffectSlotiv", "alGetAuxiliaryEffectSlotivDirect", "alGetAuxiliaryEffectSlotf", "alGetAuxiliaryEffectSlotfDirect", "alGetAuxiliaryEffectSlotfv", "alGetAuxiliaryEffectSlotfvDirect"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 878 */         }) || Checks.reportMissing("AL", "ALC_EXT_EFX"));
/*     */   }
/*     */   
/*     */   private static boolean check_EXT_STATIC_BUFFER(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 882 */     if (!ext.contains("AL_EXT_STATIC_BUFFER")) {
/* 883 */       return false;
/*     */     }
/*     */     
/* 886 */     return (Checks.checkFunctions(provider, caps, new int[] { 231, 232 }, new String[] { "alBufferDataStatic", "alBufferDataStaticDirect"
/*     */ 
/*     */ 
/*     */         
/* 890 */         }) || Checks.reportMissing("AL", "AL_EXT_STATIC_BUFFER"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_buffer_samples(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 894 */     if (!ext.contains("AL_SOFT_buffer_samples")) {
/* 895 */       return false;
/*     */     }
/*     */     
/* 898 */     return (Checks.checkFunctions(provider, caps, new int[] { 233, 234, 235, 236 }, new String[] { "alBufferSamplesSOFT", "alBufferSubSamplesSOFT", "alGetBufferSamplesSOFT", "alIsBufferFormatSupportedSOFT"
/*     */ 
/*     */ 
/*     */         
/* 902 */         }) || Checks.reportMissing("AL", "AL_SOFT_buffer_samples"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_buffer_sub_data(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 906 */     if (!ext.contains("AL_SOFT_buffer_sub_data")) {
/* 907 */       return false;
/*     */     }
/*     */     
/* 910 */     return (Checks.checkFunctions(provider, caps, new int[] { 237, 238 }, new String[] { "alBufferSubDataSOFT", "alBufferSubDataDirectSOFT"
/*     */ 
/*     */ 
/*     */         
/* 914 */         }) || Checks.reportMissing("AL", "AL_SOFT_buffer_sub_data"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_callback_buffer(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 918 */     if (!ext.contains("AL_SOFT_callback_buffer")) {
/* 919 */       return false;
/*     */     }
/*     */     
/* 922 */     return (Checks.checkFunctions(provider, caps, new int[] { 239, 240, 241, 242, 243, 244, 245, 246 }, new String[] { "alBufferCallbackSOFT", "alBufferCallbackDirectSOFT", "alGetBufferPtrSOFT", "alGetBufferPtrDirectSOFT", "alGetBuffer3PtrSOFT", "alGetBuffer3PtrDirectSOFT", "alGetBufferPtrvSOFT", "alGetBufferPtrvDirectSOFT"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 927 */         }) || Checks.reportMissing("AL", "AL_SOFT_callback_buffer"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_deferred_updates(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 931 */     if (!ext.contains("AL_SOFT_deferred_updates")) {
/* 932 */       return false;
/*     */     }
/*     */     
/* 935 */     return (Checks.checkFunctions(provider, caps, new int[] { 247, 248, 249, 250 }, new String[] { "alDeferUpdatesSOFT", "alDeferUpdatesDirectSOFT", "alProcessUpdatesSOFT", "alProcessUpdatesDirectSOFT"
/*     */ 
/*     */ 
/*     */         
/* 939 */         }) || Checks.reportMissing("AL", "AL_SOFT_deferred_updates"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_events(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 943 */     if (!ext.contains("AL_SOFT_events")) {
/* 944 */       return false;
/*     */     }
/*     */     
/* 947 */     return (Checks.checkFunctions(provider, caps, new int[] { 251, 252, 253, 254, 255, 256, 257, 258 }, new String[] { "alEventControlSOFT", "alEventControlDirectSOFT", "alEventCallbackSOFT", "alEventCallbackDirectSOFT", "alGetPointerSOFT", "alGetPointerDirectSOFT", "alGetPointervSOFT", "alGetPointervDirectSOFT"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 952 */         }) || Checks.reportMissing("AL", "AL_SOFT_events"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_source_latency(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 956 */     if (!ext.contains("AL_SOFT_source_latency")) {
/* 957 */       return false;
/*     */     }
/*     */     
/* 960 */     return (Checks.checkFunctions(provider, caps, new int[] { 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282 }, new String[] { "alSourcedSOFT", "alSourcedDirectSOFT", "alSource3dSOFT", "alSource3dDirectSOFT", "alSourcedvSOFT", "alSourcedvDirectSOFT", "alGetSourcedSOFT", "alGetSourcedDirectSOFT", "alGetSource3dSOFT", "alGetSource3dDirectSOFT", "alGetSourcedvSOFT", "alGetSourcedvDirectSOFT", "alSourcei64SOFT", "alSourcei64DirectSOFT", "alSource3i64SOFT", "alSource3i64DirectSOFT", "alSourcei64vSOFT", "alSourcei64vDirectSOFT", "alGetSourcei64SOFT", "alGetSourcei64DirectSOFT", "alGetSource3i64SOFT", "alGetSource3i64DirectSOFT", "alGetSourcei64vSOFT", "alGetSourcei64vDirectSOFT"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 967 */         }) || Checks.reportMissing("AL", "AL_SOFT_source_latency"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_source_resampler(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 971 */     if (!ext.contains("AL_SOFT_source_resampler")) {
/* 972 */       return false;
/*     */     }
/*     */     
/* 975 */     return (Checks.checkFunctions(provider, caps, new int[] { 283, 284 }, new String[] { "alGetStringiSOFT", "alGetStringiDirectSOFT"
/*     */ 
/*     */ 
/*     */         
/* 979 */         }) || Checks.reportMissing("AL", "AL_SOFT_source_resampler"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_source_start_delay(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 983 */     if (!ext.contains("AL_SOFT_source_start_delay")) {
/* 984 */       return false;
/*     */     }
/*     */     
/* 987 */     return (Checks.checkFunctions(provider, caps, new int[] { 285, 286, 287, 288 }, new String[] { "alSourcePlayAtTimeSOFT", "alSourcePlayAtTimeDirectSOFT", "alSourcePlayAtTimevSOFT", "alSourcePlayAtTimevDirectSOFT"
/*     */ 
/*     */ 
/*     */         
/* 991 */         }) || Checks.reportMissing("AL", "AL_SOFT_source_start_delay"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\ALCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */